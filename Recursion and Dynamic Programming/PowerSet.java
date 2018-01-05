package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {
    public static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(index == set.size()){
            ArrayList<Integer> empty = new ArrayList<>();
            res.add(empty);
            return res;
        }
        ArrayList<ArrayList<Integer>> prev = getPowerSet(set,index+1);
        for(ArrayList<Integer> list : prev){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(set.get(index));
            res.add(temp);
        }
        res.addAll(prev);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        System.out.println(getPowerSet(li,0));
    }
}
