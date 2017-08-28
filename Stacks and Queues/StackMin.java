package stacksandqueues;

public class StackMin extends MyStack<StackMin.NodeMin>{
    public class NodeMin{
        private int value;
        private int min;
        public NodeMin(int v, int min){
            value = v;
            this.min = min;
        }
    }

    public void push(int value){
        int newMin = Math.min(value,min());
        super.push(new NodeMin(value,newMin));
    }

    public int min(){
        if(this.isEmpty()) return Integer.MAX_VALUE;
        else return peek().min;
    }

    public int popCurr(){
        return super.pop().value;
    }

    public static void main(String args[]){
        StackMin sm = new StackMin();
        sm.push(2);
        sm.push(3);
        sm.push(4);
        sm.push(5);
        System.out.println(sm.popCurr());
        System.out.println(sm.min());
    }
}

