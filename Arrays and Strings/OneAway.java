package arraysandstrings;

public class OneAway {

    public static boolean isItOneAway(String a,String b){
        if(Math.abs(a.length() - b.length()) > 1) return false;

        String s1 = (a.length()>b.length()) ? b:a;
        String s2 = (a.length()>b.length()) ? a:b;
        int index1 = 0,index2 = 0;
        boolean foundDifference = false;

        while(index2<s2.length() && index1<s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(foundDifference) return false;
                foundDifference = true;
                if(a.length() == b.length())
                    index1++;
            }
            else{
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static boolean isOneAway(String a,String b){
        if(a.length() == b.length()){
            return oneEditReplace(a,b);
        }
        else if((a.length() - b.length()) == 1){
            return oneEditInsert(b,a);
        }
        else if((b.length() - a.length()) == 1){
            return oneEditInsert(a,b);
        }
        else
            return false;
    }

    private static boolean oneEditInsert(String a, String b) {
        int index1 = 0, index2 = 0;
        while(index2<b.length() && index1<a.length()){
            if (a.charAt(index1) != b.charAt(index2)){
                if(index1 != index2)
                    return false;
                index2++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String a, String b) {
        boolean foundDifference= false;
        for(int i =0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(foundDifference)
                    return false;
                foundDifference = true;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isItOneAway("face","bake"));
        System.out.println(isItOneAway("face","lace"));
        System.out.println(isItOneAway("face","fce"));
        System.out.println(isItOneAway("fce","face"));
    }
}
