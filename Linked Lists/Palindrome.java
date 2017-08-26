package linkedlists;

import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(Node l1){
        Node l2 = reverseAndClone(l1);
        return isEqual(l1,l2);
    }

    private static boolean isEqual(Node l1, Node l2) {
        while(l1 != null && l2 != null){
            if(l1.data != l2.data)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private static Node reverseAndClone(Node l1) {
        Node head = null;
        while(l1 != null){
            Node node = new Node(l1.data);
            node.next = head;
            head = node;
            l1 = l1.next;
        }
        return head;
    }

    public static boolean isPalindromeWithBuffer(Node l1){
        Node p1 = l1;
        Node p2 = l1;
        Stack<Integer> buffer = new Stack<Integer>();
        while(p2!=null && p2.next!=null){
            buffer.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if(p2.next == null){
            p1 = p1.next;
        }
        while(p1 != null){
            int top = buffer.pop();
            if(p1.data != top)
                return false;
            p1=p1.next;
        }
        return true;
    }

    public static void main(String args[]){
        Node exam = new Node(3);
        Node head = exam;
        exam.appendToTail(5);
        exam.appendToTail(4);
        exam.appendToTail(5);
        exam.appendToTail(3);
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print("\n");
        boolean ans = isPalindromeWithBuffer(head);
        System.out.println(ans);
    }
}
