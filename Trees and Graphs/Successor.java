package treesandgraphs;

public class Successor {
    static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;
        public Node(int value){
            this.value = value;
            left = right = parent = null;
        }
    }

    public static Node solSuccessor(Node n){
        if(n == null) return null;
        if(n.right!=null)
            return leftMostChild(n.right);
        else{
            Node curr = n;
            Node parent = n.parent;
            while(parent != null && parent.left != curr){
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static Node leftMostChild(Node node) {
        if(node == null) return null;
        while(node.left!=null)
            node = node.left;
        return node;
    }

    public static Node successor(Node n){
        if(n.right!=null){
            return minLeft(n.right);
        }
        else
            return firstLeftParent(n);
    }

    private static Node firstLeftParent(Node node) {
        if(node.parent == null) return null;//throw new RuntimeException("No Successor Found");
        if(node.parent.left == node)
            return node.parent;
        else
            return firstLeftParent(node.parent);
    }

    private static Node minLeft(Node node) {
        if(node.left == null)
            return node;
        else
            return minLeft(node.left);
    }

    public static void main(String[] args) {
        Node n = new Node(4);
        n.left = new Node(2);
        n.left.parent = n;
        n.right = new Node(6);
        n.right.parent = n;
        n.left.left = new Node(1);
        n.left.left.parent = n.left;
        n.left.right = new Node(3);
        n.left.right.parent = n.left;
        n.right.left = new Node(5);
        n.right.left.parent = n.right;
        Node t = n.right.right = new Node(7);
        n.right.right.parent = n.right;
        //System.out.println(successor(t)==null?null:successor(t).value);
        System.out.println(solSuccessor(t)==null?null:solSuccessor(t).value);

    }
}
