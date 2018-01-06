package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parens {
    public static Set<String> getParens(int n){
        Set<String> set = new HashSet<>();

        if(n == 0){
            set.add("");
            return set;
        }

        Set<String> prev = getParens(n-1);
        for(String s: prev){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    String temp = insertParenAt(s,i+1);
                    set.add(temp);
                }
            }
            set.add("()"+s);
        }

        return set;
    }

    private static String insertParenAt(String s, int i) {
        return s.substring(0,i) + "()" + s.substring(i);
    }

    private static ArrayList<String> getParensFromScratch(int n){
        ArrayList<String> list = new ArrayList<>();
        getParensFromScratch(list,n,n,new char[n*2],0);
        return list;
    }

    private static void getParensFromScratch(ArrayList<String> list, int left, int right, char[] str, int count) {
        if(left < 0 || right < left)
            return;

        if(left == 0 && right == 0)
            list.add(String.copyValueOf(str));
        else{
            if(left > 0){
                str[count] = '(';
                getParensFromScratch(list,left - 1,right,str,count+1);
            }

            if(right > left){
                str[count] = ')';
                getParensFromScratch(list,left,right - 1,str,count+1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> s = getParensFromScratch(3);
        System.out.println(s);
    }
}
