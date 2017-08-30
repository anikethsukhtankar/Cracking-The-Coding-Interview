package stacksandqueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackofPlates {
    private int numberOfStacks = 0;
    private int threshold = 10;
    private List<MyStack> buffer;
    private int currSize = 0;

    public StackofPlates(){
        buffer = new ArrayList<MyStack>();
        MyStack<Integer> t = new MyStack<Integer>();
        buffer.add(0,t);
    }

    public void push(int value){
        if(currSize == threshold){
            MyStack<Integer> s = new MyStack<>();
            s.push(value);
            numberOfStacks++;
            buffer.add(numberOfStacks,s);
            currSize=1;
        }
        else{
            buffer.get(numberOfStacks).push(value);
            currSize++;
        }

    }

    public int pop(){
        if(buffer.get(numberOfStacks).isEmpty()){
            if(numberOfStacks == 0) throw new EmptyStackException();
            numberOfStacks--;
            currSize=8;
            return (int) buffer.get(numberOfStacks).pop();
        }
        else{
            currSize--;
            return (int) buffer.get(numberOfStacks).pop();
        }

    }

    public static void main(String[] args) {
        StackofPlates s = new StackofPlates();
        for(int i=0; i<21; i++)
            s.push(i);
        for(int i=0; i<21; i++)
            System.out.println(s.pop());
    }
}
