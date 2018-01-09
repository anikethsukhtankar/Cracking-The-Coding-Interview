package SortingAndSearching;

public class QuickSort {
    public static void sort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr,low,high);
            sort(arr,low,p-1);
            sort(arr,p+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low-1;

        for(int j=low; j<high; j++){
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr,i+1,high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {8,6,4,1,2,9,0,3,3};
        sort(input,0,input.length-1);
        for(int x : input)
            System.out.print(x);
    }
}
