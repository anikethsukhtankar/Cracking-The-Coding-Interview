package stacksandqueues;

import java.util.EmptyStackException;

public class ThreeInOne {
    private int stackCapacity;
    private int numberOfStacks = 3;
    private int[] values;
    private int[] size;

    public ThreeInOne(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        size = new int[numberOfStacks];
    }

    public int indexOfTop(int stackNum){
        int offset = stackNum*stackCapacity;
        int sizecurr = size[stackNum];
        return offset + sizecurr - 1;
    }

    public void push(int stackNum, int value) throws FullStackException{
        if(isFull(stackNum)) throw new FullStackException();
        size[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) throws EmptyStackException{
        if(isEmpty(stackNum)) throw new EmptyStackException();
        int value = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = 0;
        size[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)) throw new EmptyStackException();
        return values[indexOfTop(stackNum)];
    }

    private boolean isFull(int stackNum) {
        return size[stackNum] == stackCapacity;
    }

    private boolean isEmpty(int stackNum){
        return size[stackNum] == 0;
    }

    class FullStackException extends RuntimeException{
        public FullStackException(){
            super("Stack is Full");
        }
    }

    public static void main(String args[]){
        ThreeInOne tio = new ThreeInOne(10);
        tio.push(0,44);
        tio.push(0,54);
        tio.push(0,64);
        tio.push(1,47);
        tio.push(1,57);
        tio.push(2,49);
        tio.push(2,59);
        System.out.println(tio.pop(0));
        System.out.println(tio.pop(0));
        System.out.println(tio.peek(1));
    }
}
