package treesandgraphs;

public class FirstCommonAncestor {
    static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int v){
            value = v;
            left = right = null;
        }
    }

    public static Node commonAncestor(Node root, Node p, Node q){
        if(!covers(root,p) || !covers(root,q))
            return null;
        return ancestorHelper(root,p,q);
    }

    private static Node ancestorHelper(Node root, Node p, Node q) {
        if(root == null || root == p || root == q)
            return root;
        boolean pIsOnLeft = covers(root.left,p);
        boolean qIsOnLeft = covers(root.left,q);
        if(pIsOnLeft != qIsOnLeft) return root;

        Node childSide = pIsOnLeft ? root.left:root.right;
        return ancestorHelper(childSide,p,q);
    }

    private static boolean covers(Node root, Node p) {
        if(root == null) return false;
        if(root == p) return true;
        return covers(root.left,p) || covers(root.right,p);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.left.left.left = new Node(3);
        Node p = root.left.left.right = new Node(7);
        Node q = root.left.right.right = new Node(17);
        System.out.println(commonAncestor(root,p,q).value);
    }
}
