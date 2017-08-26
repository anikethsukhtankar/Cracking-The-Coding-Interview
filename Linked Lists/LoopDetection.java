package linkedlists;

import java.util.HashSet;

public class LoopDetection {
    public static Node loopDetect(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        if(fast == null || fast.next == null)
            return null;

        slow = head;

        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static Node myLoopDetect(Node head){
        HashSet<Node> buffer = new HashSet<Node>();
        Node curr = head;
        while(curr != null){
            if(buffer.contains(curr))
                return curr;
            else
                buffer.add(curr);
            curr = curr.next;
        }
        return null;
    }

    public static void main(String args[]){
        Node exam = new Node(7);
        Node head = exam;
        exam.appendToTail(1);
        exam.appendToTail(6);
        Node tail = head.next.next;
        Node temp1 = new Node(17);
        Node temp2 = new Node(4);
        temp1.next = temp2;
        tail.next = temp1;
        temp2.next = tail;
        boolean foundTail = false;
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            if(n==tail){
                if(foundTail)
                    break;
                else
                    foundTail = true;
            }
            n=n.next;
        }
        System.out.print("\n");
        n = myLoopDetect(head);
        System.out.println(n.data);
    }
}
