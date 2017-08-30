package stacksandqueues;

import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> t){
        Stack<Integer> s = new Stack<Integer>();
        while(!t.isEmpty()){
            int tmp = t.pop();
            while(!s.isEmpty() && s.peek()>tmp)
                t.push(s.pop());
            s.push(tmp);
        }
        while(!s.isEmpty()) t.push(s.pop());
        return t;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(5);
        st.push(3);
        st.push(4);
        st.push(9);
        st.push(6);
        st = sortStack(st);
        while(!st.isEmpty())
            System.out.println(st.pop());

    }
}
