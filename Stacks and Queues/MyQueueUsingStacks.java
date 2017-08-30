package stacksandqueues;

public class MyQueueUsingStacks<T> {
    private MyStack<T> stackNewest;
    private MyStack<T> stackOldest;

    public MyQueueUsingStacks(){
        stackNewest = new MyStack<T>();
        stackOldest = new MyStack<T>();
    }

    public int size(){
        return stackNewest.size()+stackOldest.size();
    }

    public void add(T value){
        stackNewest.push(value);
    }

    public void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }

    public static void main(String[] args) {
        MyQueueUsingStacks<Integer> q = new MyQueueUsingStacks<>();
        for(int i=0; i<10; i++)
            q.add(i);
        for(int i=0; i<10; i++)
            System.out.println(q.remove());
    }
}
