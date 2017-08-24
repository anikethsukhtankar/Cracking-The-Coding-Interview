package arraysandstrings;

public class IsPermutation {

    public static String sort(String s){
        char[] content =  s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation(String a, String b){
        if(a.length() != b.length()) return false;

        return sort(a).equals(sort(b));
    }

    public static boolean isPermutation2(String a, String b){
        if(a.length() != b.length()) return false;

        int[] count = new int[128];

        for(char ch : a.toCharArray()){
            count[ch]++;
        }
        for(int i=0; i<b.length(); i++){
            int val = (int) b.charAt(i);
            count[val]--;
            if(count[val]<0)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        boolean ans = isPermutation2("madam","dmaam");
        System.out.println(ans);
    }
}
