package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class GroupAnagrams {
    static class AnagramComparator implements Comparator<String> {
        private String orderedString(String s){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        public int compare(String a, String b){
            return orderedString(a).compareTo(orderedString(b));
        }
    }

    public static void sort(String[] arr){
        //Arrays.sort(arr,new AnagramComparator());
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : arr){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            ArrayList<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);
            //System.out.println(list);
        }
        int i = 0;
        //System.out.println(map);
        for(String s : map.keySet()){
            for(String t : map.get(s)){
                arr[i] = t;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String[] inp = {"cat","doggy","tac","oggy","bakka","yogg"};
        sort(inp);
        for(String x : inp)
            System.out.print(x + " ");
    }
}
