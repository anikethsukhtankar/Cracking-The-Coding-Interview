package stacksandqueues;

import java.util.Stack;

public class StackMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public StackMin2(){
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if(value<min()){
            s2.push(value);
        }
        super.push(value);
    }

    public int min(){
        if(s2.isEmpty()) return Integer.MAX_VALUE;
        else return s2.peek();
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min())
            s2.pop();
        return value;
    }

    public static void main(String args[]){
        StackMin2 sm = new StackMin2();
        sm.push(2);
        sm.push(3);
        sm.push(4);
        sm.push(5);
        System.out.println(sm.pop());
        System.out.println(sm.min());
    }
}
