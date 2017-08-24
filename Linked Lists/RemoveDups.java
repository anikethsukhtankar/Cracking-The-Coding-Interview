package linkedlists;

import java.util.HashSet;

public class RemoveDups {
    public static void removeDupsWithBuffer(Node dup){
        HashSet<Integer> buffer = new HashSet<>();
        Node prev = null;
        Node n = dup;
        while(n != null){
            if(buffer.contains(n.data)){
                prev.next = n.next;
            }
            else{
                buffer.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public static void removeDupsWithoutBuffer(Node dup){
        Node n = dup;
        while(n != null){
            Node runner = n;
            while(runner.next != null){
                if(runner.next.data == n.data){
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
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
        removeDupsWithoutBuffer(head);
        n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
}

