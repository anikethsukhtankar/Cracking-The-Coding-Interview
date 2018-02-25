package SortingAndSearching;

public class SparseSearch {
    public static int search(String[] strs, String str, int low, int high){
        if(low > high)
            return -1;

        int mid = (low+high)/2;
        if(strs[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if(left < low && right > high)
                    return -1;
                else if(left >= low && !strs[left].isEmpty()){
                    mid = left;
                    break;
                }
                else if(right <= high && !strs[high].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if(strs[mid].compareTo(str) == 0){
            return mid;
        }
        else if(strs[mid].compareTo(str) < 0){
            return search(strs, str, mid+1, high);
        }
        else{
            return search(strs, str, low, mid-1);
        }
    }

    public static int search(String[] strs, String str){
        if(strs == null || str == null || str.equals("")){
            return -1;
        }
        return search(strs,str,0,strs.length-1);
    }

    public static void main(String[] args) {
        String[] input = {"at","","","","ball","","","car","","","dad","",""};
        System.out.println(search(input,"dad"));
    }
}
