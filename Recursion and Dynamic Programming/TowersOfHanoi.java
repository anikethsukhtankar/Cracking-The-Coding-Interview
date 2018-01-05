package RecursionAndDP;

import java.util.Stack;

public class TowersOfHanoi {
    static class Tower{
        Stack<Integer> st;
        int index;

        Tower(int i){
            st = new Stack<>();
            index = i;
        }

        public int getIndex(){
            return index;
        }

        public void add(int i){
            if(!st.isEmpty() && st.peek() <= i)
                System.out.println("Problem placing disk");
            else
                st.push(i);
        }

        public void moveTopTo(Tower b){
            int top = st.pop();
            b.add(top);
        }

        public void printStack(){
            while(!st.isEmpty())
                System.out.println(st.pop());
        }

        public void moveDisksTo(int n,Tower dest, Tower buff){
            if(n<=0) return;
            moveDisksTo(n-1,buff,dest);
            moveTopTo(dest);
            buff.moveDisksTo(n-1,dest,this);
        }
    }

    public static void main(String[] args) {
        Tower[] tw = new Tower[3];
        for(int i = 0; i<3; i++)
            tw[i] = new Tower(i);
        for(int i = 10; i>=0; i--)
            tw[0].add(i);
        tw[0].moveDisksTo(11,tw[2],tw[1]);
        tw[2].printStack();
    }
}
