package SortingAndSearching;

public class SearchInRotatedArray {
    public static int search(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == x)
                return mid;
            if(arr[mid] < arr[high]){
                if(arr[mid] < x && x <= arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
            else if(arr[mid] > arr[high]){
                if(x >= arr[low] && x < arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{
                if(arr[mid] != arr[low])
                    high = mid - 1;
                else
                    high = high-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inp = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println(search(inp,5));
    }
}
