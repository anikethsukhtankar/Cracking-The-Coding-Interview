package linkedlists;

public class SumLists {
    public static Node sumLists(Node l1, Node l2, int carry){
        if(l1 == null && l2 == null && carry ==0)
            return null;

        int value = carry;
        if(l1 != null)
            value += l1.data;
        if(l2 != null)
            value += l2.data;

        Node result = new Node(value%10);

        if(l1 != null || l2 != null){
            Node more = sumLists(l1 == null ? null:l1.next, l2 == null ? null:l2.next, value>10 ? 1:0);
            result.next = more;
        }

        return result;
    }

    static class PartialSum{
        public Node sum = null;
        public int carry = 0;
    }

    public static int length(Node l1){
        int length = 0;
        Node temp = l1;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static Node padZero(Node l, int padding){
        Node head = l;
        for(int i=0; i< padding; i++){
            head = addBefore(head,0);
        }
        return head;
    }

    public static Node addBefore(Node head, int value){
        Node node = new Node(value);
        if(head != null)
            node.next = head;
        return node;
    }

    public static Node addLists(Node l1, Node l2){
        int len1 = length(l1);
        int len2 = length(l2);

        if(len1<len2){
            padZero(l1,len2-len1);
        }
        else{
            padZero(l2,len1-len2);
        }


        PartialSum sum = addListsHelper(l1,l2);

        if(sum.carry == 0)
            return sum.sum;
        else
            return addBefore(sum.sum,sum.carry);
    }

    private static PartialSum addListsHelper(Node l1, Node l2) {
        if(l1 == null && l2 == null)
            return new PartialSum();

        PartialSum sum = addListsHelper(l1.next,l2.next);

        int value = sum.carry + l1.data + l2.data;

        Node result = addBefore(sum.sum, value % 10);

        sum.sum = result;
        sum.carry = value/10;
        return sum;
    }

    public static void main(String args[]){
        Node exam = new Node(7);
        Node head = exam;
        exam.appendToTail(1);
        exam.appendToTail(6);
        Node exam2 = new Node(5);
        Node head2 = exam2;
        exam2.appendToTail(9);
        exam2.appendToTail(2);
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
        n = addLists(head,head2);
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
}
