package treesandgraphs;

public class ValidateBST {

    static Integer last_printed = null;

    static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static boolean checkBST(Node n){
        if(n==null) return true;

        if(!checkBST(n.left)) return false;

        if(last_printed!=null && n.value<=last_printed) return false;
        last_printed = n.value;

        if(!checkBST(n.right)) return false;
        return true;
    }

    public static boolean isBST(Node n){
        return isBST(n,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean isBST(Node n,int min, int max){
        if(n==null) return true;
        if(n.value<=min || n.value>max) return false;
        return isBST(n.left,min,n.value) && isBST(n.right,n.value,max);
    }

    public static void main(String[] args) {
        Node n = new Node(4);
        n.left = new Node(2);
        n.right = new Node(6);
        n.left.left = new Node(1);
        n.left.right = new Node(3);
        n.right.left = new Node(5);
        n.right.right = new Node(7);
        //System.out.println(isBST(n));
        System.out.println(checkBST(n));

        Node p = new Node(11);
        p.left = new Node(7);
        p.right = new Node(13);
        p.left.left = new Node(3);
        p.left.right = new Node(12);
        p.right.left = new Node(12);
        p.right.right = new Node(15);
        //System.out.println(isBST(p));
        System.out.println(checkBST(n)); // won't work for duplicate values! I know I know
    }
}
