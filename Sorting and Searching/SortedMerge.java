package SortingAndSearching;

public class SortedMerge {
    public static void merge(int[] A, int[] B, int Alen, int Blen){
        int idxA = Alen-1;
        int idxB = Blen - 1;
        int curr = Alen + Blen - 1;

        while(idxB >= 0){
            if(idxA >= 0 && A[idxA] > B[idxB]){
                A[curr] = A[idxA];
                idxA--;
            }
            else{
                A[curr] = B[idxB];
                idxB--;
            }
            curr--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,6,7,8,-1,-1,-1,-1,-1};
        int[] B = new int[]{3,4,5,32,76};
        merge(A,B,5,5);
        for(int x : A)
            System.out.print(x+" ");
    }
}
