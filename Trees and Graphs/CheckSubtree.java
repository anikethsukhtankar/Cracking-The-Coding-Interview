package treesandgraphs;

public class CheckSubtree {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static boolean checkSubtreeUsingTraversal(TreeNode t1, TreeNode t2){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        generateTraversal(t1,s1);
        generateTraversal(t2,s2);

        return s1.indexOf(s2.toString()) != -1;

    }

    public static void generateTraversal(TreeNode t, StringBuilder s){
        if(t == null){
            s.append('X');
            return;
        }
        s.append(t.data);
        generateTraversal(t.left,s);
        generateTraversal(t.right,s);
    }

    public static boolean checkSubtreeUsingRecursion(TreeNode t1,TreeNode t2){
        if(t2 == null)
            return true;
        return checkSubtree(t1,t2);
    }

    public static boolean checkSubtree(TreeNode t1,TreeNode t2){
        if(t1 == null)
            return false;
        else if(t1.data == t2.data && matchTree(t1,t2))
            return true;
        else
            return checkSubtree(t1.left,t2) || checkSubtree(t1.right,t2);
    }

    public static boolean matchTree(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null)
            return true;
        else if(t1 == null || t2 == null)
            return false;
        else if(t1.data != t2.data)
            return false;
        else
            return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(7);
        System.out.println(checkSubtreeUsingTraversal(root1,root2));
        System.out.println(checkSubtreeUsingRecursion(root1,root2));
    }
}
