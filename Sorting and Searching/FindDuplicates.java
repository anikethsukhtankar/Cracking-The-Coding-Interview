package SortingAndSearching;

import java.util.ArrayList;

public class FindDuplicates {
    public static ArrayList<Integer> checkDuplicate(int[] nums){
        BitSet bs = new BitSet(32000);
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : nums){
            int num0 = num-1;
            if(bs.get(num0))
                res.add(num);
            else
                bs.set(num0);
        }
        return res;
    }

    static class BitSet{
        int[] bitset;

         BitSet(int size){
             bitset = new int[(size/32) + 1];
         }

         public boolean get(int index){
             return (bitset[index/32] & (1<<(index%32))) != 0;
         }

         public void set(int index){
             bitset[index/32] |= (1<<index%32);
         }
    }

    public static void main(String[] args) {
        int[] input = {1,4,6,3,8,3,6,4,9};
        System.out.println(checkDuplicate(input));
    }
}
