package stacksandqueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<StackTem> buffer = new ArrayList<StackTem>();
    public int capacity;
    
    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }
    
    public void push(int value){
        StackTem last = getLastStack();
        if(last != null && !last.isFull())
            last.push(value);
        else{
            StackTem s = new StackTem();
            s.push(value);
            buffer.add(s);
        }
    }

    private StackTem getLastStack() {
        if(buffer.size() == 0) return null;
        return buffer.get(buffer.size() - 1);
    }

    public int pop(){
        StackTem last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int v = last.pop();
        if(last.isEmpty()) buffer.remove(buffer.size()-1);
        return v;
    }
    
    public boolean isEmpty(){
        StackTem last = getLastStack();
        return last==null || last.isEmpty();
    }
    
    public int popAt(int index){
        return leftShift(index,true);
    }

    private int leftShift(int index, boolean removeFromTop) {
        StackTem s = buffer.get(index);
        int removedItem;
        if(removeFromTop) removedItem = s.pop();
        else removedItem = s.removeBottom();
        if(s.isEmpty())
            buffer.remove(index);
        else{
            int v = leftShift(index+1,false);
            s.push(v);
        }
        return removedItem;
    }

    public static void main(String[] args) {
        SetOfStacks s = new SetOfStacks(10);
        for(int i=0; i<21; i++)
            s.push(i);
        for(int i=0; i<21; i++)
            System.out.println(s.pop());
    }
}

class StackTem{
    
}
