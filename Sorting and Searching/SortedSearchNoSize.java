package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortedSearchNoSize {
    public static class Listy{
        ArrayList<Integer> list;

        public Listy(int capacity){
            list = new ArrayList<Integer>(capacity);
            Random rand = new Random();
            int end = rand.nextInt(capacity);
            int i;
            for(i=0; i < end; i++){
                list.add(rand.nextInt(capacity));
            }
            Collections.sort(list);
            while(i < capacity){
                list.add(-1);
                i++;
            }


        }

        public int elementAt(int index){
            return list.get(index);
        }
    }

    public static int search(Listy list, int target){
        int index = 1;
        while(list.elementAt(index) != -1 && list.elementAt(index) < target){
            index *= 2;
        }
        return modBinSearch(list, (index/2)-1, index-1, target);
    }

    public static int modBinSearch(Listy list, int low, int high, int target){
        while(low <= high){
            int mid = (low+high)/2;
            int midElem = list.elementAt(mid);
            if(target < midElem || midElem == -1)
                high = mid-1;
            else if(target > midElem)
                low = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Listy l = new Listy(20);
        for(int i=0; i<20; i++)
            System.out.print(l.elementAt(i)+" ");
        System.out.println();
        System.out.println(search(l,l.elementAt(3)));
    }
}
