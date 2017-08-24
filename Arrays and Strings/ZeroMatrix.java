package arraysandstrings;

class ZeroMatrix{
    public static void zeroMatrix(int matrix[][]){
        boolean[] rowzero = new boolean[matrix.length];
        boolean[] colzero = new boolean[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowzero[i] = true;
                    colzero[j] = true;
                }
            }
        }

        for(int i=0; i<rowzero.length; i++){
            if(rowzero[i]){
                for(int j=0; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=0; j<colzero.length; j++){
            if(colzero[j]){
                for(int i=0; i<matrix[0].length; i++){
                    matrix[i][j] = 0;
                }
            }
        }


    }

    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4,5},{6,7,8,0,10},{11,12,13,14,15},{16,0,18,19,20},{21,21,23,24,25}};
        zeroMatrix(matrix);
        for(int i = 0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
