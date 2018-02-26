package SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {
    public static void sortValleyPeakSimple(int[] arr){
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i+=2){
            swap(arr,i-1,i);
        }
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void sortValleyPeak(int[] arr){
        for(int i=1; i<arr.length; i+=2){
            int biggestIndex = getMaxIndex(arr,i-1,i,i+1);
            if(i != biggestIndex){
                swap(arr,i,biggestIndex);
            }
        }
    }

    private static int getMaxIndex(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int aValue = (a >=0 && a<len) ? arr[a] : Integer.MIN_VALUE;
        int bValue = (b >=0 && b<len) ? arr[b] : Integer.MIN_VALUE;
        int cValue = (c >=0 && c<len) ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue,Math.max(bValue,cValue));
        return (max == aValue) ? a: (max == bValue) ? b : c;
    }

    public static void main(String[] args) {
        int[] input = {1,3,3,1,3,1,1,3,3,1};
        sortValleyPeak(input);
        for(int x:input)
            System.out.print(x);
    }
}
