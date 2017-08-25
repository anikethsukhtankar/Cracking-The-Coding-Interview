package linkedlists;

public class Partition {
    public static Node partition(Node head, int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(head != null){
            Node next = head.next;
            head.next = null;
            if(head.data < x){
                if(beforeStart == null){
                    beforeStart = head;
                    beforeEnd = beforeStart;
                }
                else{
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }
            else{
                if(afterStart == null){
                    afterStart = head;
                    afterEnd = afterStart;
                }
                else{
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }
        if(beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static Node partition2(Node node, int x){
        Node head = node;
        Node tail = node;

        while(node!=null){
            Node next = node.next;
            if(node.data<x){
                node.next = head;
                head = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String args[]){
        Node exam = new Node(3);
        Node head = exam;
        exam.appendToTail(5);
        exam.appendToTail(8);
        exam.appendToTail(5);
        exam.appendToTail(10);
        exam.appendToTail(2);
        exam.appendToTail(1);
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print("\n");
        head = partition2(head,5);
        n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
}
