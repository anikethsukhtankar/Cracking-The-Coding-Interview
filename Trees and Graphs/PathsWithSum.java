package treesandgraphs;

import java.util.HashMap;

public class PathsWithSum {
    static class TreeNode{
        private int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int d){
            data = d;
            left = right = null;
        }
    }

    public static int pathWithSumsBruteForce(TreeNode root,int sum){
        if(root == null) return 0;

        int pathsFromRoot = countPathsFromNode(root,sum,0);

        int pathsonleft = pathWithSumsBruteForce(root.left,sum);
        int pathsonright = pathWithSumsBruteForce(root.right,sum);

        return pathsFromRoot+pathsonleft+pathsonright;
    }

    public static int countPathsFromNode(TreeNode node, int targetSum, int currSum){
        if(node == null) return 0;

        currSum += node.data;

        int totalPaths = 0;
        if(currSum == targetSum)
            totalPaths++;
        totalPaths += countPathsFromNode(node.left,targetSum,currSum);
        totalPaths += countPathsFromNode(node.right,targetSum,currSum);
        return totalPaths;
    }

    public static int pathWithSums(TreeNode root, int sum){
        HashMap<Integer,Integer> presum = new HashMap<>();
        presum.put(0,1);
        return helper(root,0,sum,presum);
    }

    public static int helper(TreeNode node, int currSum, int targetSum, HashMap<Integer,Integer> presum){
        if(node==null) return 0;
        currSum = currSum + node.data;
        int res = presum.getOrDefault(currSum-targetSum,0);
        presum.put(currSum,presum.getOrDefault(currSum,0)+1);
        res += helper(node.left,currSum,targetSum,presum) + helper(node.right,currSum,targetSum,presum);
        presum.put(currSum,presum.get(currSum)-1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(pathWithSums(root,8));
        System.out.println(pathWithSumsBruteForce(root,8));
    }
}
