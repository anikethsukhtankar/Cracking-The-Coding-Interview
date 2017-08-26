package stacksandqueues;

public class ArrayBasedStack {
    private int top;
    private int[] storage;

    public ArrayBasedStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        storage = new int[capacity];
        top = -1;
    }

    public class StackException extends RuntimeException{
        public StackException(String message){
            super(message);
        }
    }

    public void push(int item){
        if(top == storage.length) throw new StackException("Stack Overflow");
        top++;
        storage[top] = item;
    }

    public int peek(){
        if(top == -1) throw new StackException("Stack is Empty");
        return storage[top];
    }

    public int pop(){
        if(top == -1) throw new StackException("Stack is Empty");
        int item = storage[top];
        top--;
        return item;
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
