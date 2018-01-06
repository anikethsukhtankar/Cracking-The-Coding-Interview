package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDups {
    public static ArrayList<String> getPerm(String s){
        ArrayList<String> res = new ArrayList<String>();
        HashMap<Character,Integer> map = getFreqCount(s);
        getPerm(map,"",s.length(),res);
        return res;
    }

    private static void getPerm(HashMap<Character, Integer> map, String s, int length, ArrayList<String> res) {
        if(length == 0){
            res.add(s);
            return;
        }

        for(Character c : map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c,count-1);
                getPerm(map,s+c,length-1,res);
                map.put(c,count);
            }
        }
    }

    private static HashMap<Character,Integer> getFreqCount(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(getPerm("aaaaab"));
    }
}
