package treesandgraphs;

public class MinimalTree {
    static class BTNode {
        private int data;
        BTNode left, right;

        public BTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static BTNode minimalTree(int[] array){
        return minimalTree(array,0,array.length-1);
    }

    public static BTNode minimalTree(int[] array,int start,int end){
        if(end<start) return null;
        int mid = (start+end)/2;
        BTNode node = new BTNode(array[mid]);
        node.left = minimalTree(array,start,mid-1);
        node.right = minimalTree(array,mid+1,end);
        return node;
    }

    public static void inorder(BTNode node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BTNode root = minimalTree(arr);
        inorder(root);
    }
}
