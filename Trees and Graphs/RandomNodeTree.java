package treesandgraphs;

import java.util.Random;

public class RandomNodeTree {
    TreeNode root = null;

    public RandomNodeTree(int d){
        root = new TreeNode(d);
    }

    public int size(){
        return root==null? 0:root.size;
    }

    public TreeNode getRandomNode(){
        if(root == null) return null;

        Random random = new Random();
        int index = random.nextInt(size());
        return root.getIthNode(index);
    }

    public void insert(int d){
        if(root == null)
            root = new TreeNode(d);
        else
            root.insert(d);
    }

    public TreeNode find(int d){
        if(root==null) return null;
        else
            return root.find(d);
    }

    public static void main(String[] args) {
        RandomNodeTree root = new RandomNodeTree(4);
        root.insert(2);
        root.insert(6);
        root.insert(1);
        root.insert(3);
        root.insert(5);
        root.insert(7);
        System.out.println(root.getRandomNode().data);
    }
}

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public TreeNode getRandomNode(){
        int leftSize = left==null ? 0:left.size;
        Random random = new Random();
        int index = random.nextInt(size);
        if(index<leftSize)
            return left.getRandomNode();
        else if(index == size)
            return this;
        else
            return right.getRandomNode();
    }

    public void insert(int d){
        if(d<=data){
            if(left==null)
                left = new TreeNode(d);
            else
                left.insert(d);
        }
        else{
            if(right==null)
                right = new TreeNode(d);
            else
                right.insert(d);

        }
        size++;
    }

    public TreeNode find(int d){
        if(d==data)
            return this;
        else if(d<data)
            return left==null?null:left.find(d);
        else if(d>data)
            return right==null?null:right.find(d);
        return null;
    }

    public TreeNode getIthNode(int index) {
        int leftSize = left == null? 0:left.size;
        if(index<leftSize){
            return left.getIthNode(index);
        }
        else if(index == leftSize){
            return this;
        }
        else{
            return right.getIthNode(index-(leftSize+1));
        }
    }

}
