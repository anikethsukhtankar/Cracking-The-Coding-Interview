package RecursionAndDP;

import java.util.ArrayList;

public class PermutationWithoutDups {
    public static ArrayList<String> perm(String s){
        if(s == null) return null;

        ArrayList<String> list = new ArrayList<>();
        if(s.length() == 0){
            list.add("");
            return list;
        }

        char c = s.charAt(0);
        String rem = s.substring(1);
        ArrayList<String> words = perm(rem);
        for(String word : words){
            for(int j=0; j<=word.length(); j++){
                String temp = putCharAt(c,word,j);
                list.add(temp);
            }
        }

        return list;
    }

    private static ArrayList<String> getPerm(String s){
        if(s == null) return null;

        int len = s.length();

        ArrayList<String> res = new ArrayList<>();
        if(len == 0){
            res.add("");
            return res;
        }

        for(int i=0; i<len ; i++){
            String start = s.substring(0,i);
            String end = s.substring(i+1);
            ArrayList<String> words = getPerm(start+end);
            for(String word : words){
                res.add(s.charAt(i) + word);
            }
        }

        return res;
    }

    static ArrayList<String> getPermViaPre(String s){
        ArrayList<String> res = new ArrayList<>();
        getPermViaPre("",s,res);
        return res;
    }

    private static void getPermViaPre(String prefix, String rem, ArrayList<String> res) {
        if(rem.length() == 0)
            res.add(prefix);

        int len = rem.length();

        for(int i=0; i<len; i++){
            getPermViaPre(prefix+rem.charAt(i),rem.substring(0,i)+rem.substring(i+1),res);
        }
    }

    private static String putCharAt(char c, String word, int j) {
        return word.substring(0,j) + c + word.substring(j);
    }

    public static void main(String[] args) {
        System.out.println(getPermViaPre("abc"));
    }
}
