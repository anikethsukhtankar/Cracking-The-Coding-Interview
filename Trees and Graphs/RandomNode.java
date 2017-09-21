package treesandgraphs;

import java.util.Random;

public class RandomNode {
    public int data;
    public RandomNode left;
    public RandomNode right;
    int size = 0;

    public RandomNode(int d) {
        data = d;
        size = 1;
    }

    public RandomNode getRandomNode(){
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
                left = new RandomNode(d);
            else
                left.insert(d);
        }
        else{
            if(right==null)
                right = new RandomNode(d);
            else
                right.insert(d);

        }
        size++;
    }

    public RandomNode find(int d){
        if(d==data)
            return this;
        else if(d<data)
            return left==null?null:left.find(d);
        else if(d>data)
            return right==null?null:right.find(d);
        return null;
    }

}
