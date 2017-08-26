package linkedlists;

public class Intersection {
    public static Node intersection(Node l1, Node l2){
        if(l1 == null || l2 == null)
            return null;
        Result r1= getTailAndSize(l1);
        Result r2= getTailAndSize(l2);

        if(r1.tail != r2.tail)
            return null;

        Node shorter = r1.size < r2.size ? l1:l2;
        Node longer = r1.size < r2.size ? l2:l1;

        longer = getKthNode(longer,Math.abs(r1.size-r2.size));

        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    private static Node getKthNode(Node longer, int k) {
        Node current = longer;
        while(k>0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }

    private static Result getTailAndSize(Node l1) {
        Node current = l1;
        int size = 1;
        while(current.next != null){
            size++;
            current = current.next;
        }
        return new Result(current,size);
    }

    public static class Result{
        public Node tail;
        public int size;
        public Result(Node tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }

    public static void main(String args[]){
        Node exam = new Node(7);
        Node head = exam;
        exam.appendToTail(1);
        exam.appendToTail(6);
        Node tail = head.next.next;
        Node exam2 = new Node(5);
        Node head2 = exam2;
        exam2.appendToTail(9);
        exam2.appendToTail(2);
        Node tail2 = head2.next.next;
        Node temp1 = new Node(17);
        temp1.appendToTail(4);
        tail.next = temp1;
        tail2.next = temp1;
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print("\n");
        n = head2;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print("\n");
        n = intersection(head,head2);
        System.out.println(n.data);
    }
}
