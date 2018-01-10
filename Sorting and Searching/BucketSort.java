package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void sort(int[] arr){
        if(arr.length == 0) return;

        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println(max);
        System.out.println(min);
        int bucCount = (max - min)/5 + 1;
        System.out.println(bucCount);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(bucCount);
        for(int i=0; i<bucCount; i++)
            list.add(new ArrayList<Integer>());

        for(int i=0; i<arr.length; i++){
            list.get((arr[i]-min)/5).add(arr[i]);
        }

        System.out.println(list);

        int curr = 0;

        for(int i = 0; i < bucCount; i++){
            Collections.sort(list.get(i));
            for(int j=0; j<list.get(i).size(); j++)
                arr[curr++] = list.get(i).get(j);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] input = {3,4,2,6,1,0,0,7,6,9};
        sort(input);
        for(int x : input)
            System.out.print(x);
    }
}
