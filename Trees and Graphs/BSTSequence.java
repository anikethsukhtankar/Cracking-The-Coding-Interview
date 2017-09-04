package treesandgraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BSTSequence {
    static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
            left = right = null;
        }
    }

    public static ArrayList<LinkedList<Integer>> allSequences(Node node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if(node == null){
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.value);

        ArrayList<LinkedList<Integer>> leftseq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightseq = allSequences(node.right);

        for(LinkedList<Integer> a : leftseq){
            for(LinkedList<Integer> b : rightseq){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weave(a,b,weaved,prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public static void weave(LinkedList<Integer> first,LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weave(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weave(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left= new Node(11);
        root.left.left = new Node(9);
        root.right = new Node(14);
        root.right.left = new Node(13);
        root.right.right = new Node(15);
        for(LinkedList<Integer> s : allSequences(root)){
            Iterator<Integer> li = s.listIterator();
            while(li.hasNext()){
                System.out.print(li.next()+" ");
            }
            System.out.println();
        }
    }
}
