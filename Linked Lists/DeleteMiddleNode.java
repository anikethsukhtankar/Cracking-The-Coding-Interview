package linkedlists;

public class DeleteMiddleNode {
    public static boolean deleteMiddleNode(Node n){
        if(n==null || n.next==null){
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
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
        n = head;
        while(n.data!=4){
            n=n.next;
        }
        System.out.print("\n");
        deleteMiddleNode(n);
        n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
}


