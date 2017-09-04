package treesandgraphs;

public class FirstCommonAncestor {
    static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;
        public Node(int v){
            value = v;
            left = right = null;
        }
    }

    public static Node commonAncestorWithParent(Node root, Node p, Node q){
        int delta = depth(p) - depth(q);
        Node first = delta>0?q:p;
        Node second = delta>0?p:q;
        second = goUpBy(second,delta);
        while(first!=second && first != null && second !=null){
            first = first.parent;
            second = second.parent;
        }
        return (first==null || second == null)? null: first;
    }

    public static Node goUpBy(Node p, int delta){
        while(delta>0 && p!=null){
            p=p.parent;
            delta--;
        }
        return p;
    }

    public static int depth(Node p){
        int depth = 0;
        while(p!=null){
            p = p.parent;
            depth++;
        }
        return depth;
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
        root.left.parent = root;
        root.right = new Node(30);
        root.right.parent = root;
        root.left.left = new Node(5);
        root.left.left.parent = root.left;
        root.left.right = new Node(15);
        root.left.right.parent = root.left;
        root.left.left.left = new Node(3);
        root.left.left.left.parent = root.left.left;
        Node p = root.left.left.right = new Node(7);
        p.parent = root.left.left;
        Node q = root.left.right.right = new Node(17);
        q.parent = root.left.right;
        System.out.println(commonAncestorWithParent(root,p,q).value);
    }
}
