package arraysandstrings;

class RotateMatrix{
    public static void rotateMatrix(int matrix[][]){
        int rows = matrix.length;
        int column = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=i; j<column; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<column/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][column-1-j];
                matrix[i][column-1-j] = temp;
            }
        }

    }

    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        rotateMatrix(matrix);
        for(int i = 0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
