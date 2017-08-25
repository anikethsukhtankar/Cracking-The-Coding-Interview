package linkedlists;

public class ReturnKthToLast {
    public static Node returnKthToLast(Node head, int k){
        Node p1 = head;
        Node p2 = head;
        for(int i=0; i<k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }
        while(p1 != null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }

    public static int returnKthToLastRecursive(Node head, int k){
        if(head == null)
            return 0;
        int index = returnKthToLastRecursive(head.next,k)+1;
        if(index == k){
            System.out.println(head.data);
        }
        return index;
    }

    static class Index{
        public int index = 0;
    }

    public static Node returnKthToLastWrapper(Node head, int k){
        Index idx = new Index();
        return returnKthToLastWrapper(head,k,idx);

    }

    public static Node returnKthToLastWrapper(Node head, int k, Index idx){
        if(head == null) return null;

        Node node = returnKthToLastWrapper(head.next,k,idx);
        idx.index = idx.index+1;
        if(idx.index == k){
            return head;
        }
        return node;
    }

    public static void main(String args[]){
        Node exam = new Node(3);
        Node head = exam;
        exam.appendToTail(5);
        exam.appendToTail(4);
        exam.appendToTail(5);
        exam.appendToTail(6);
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print("\n");
        Node temp = returnKthToLastWrapper(head,3);
        System.out.println(temp.data);
    }
}
