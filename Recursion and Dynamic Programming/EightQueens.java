package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {
    public static void getEightQueens(int row, Integer[] columns, ArrayList<Integer[]> result){
        if(row == 8)
            result.add(columns.clone());

        for(int col = 0; col < 8; col++){
            if(isValid(columns,row,col)){
                columns[row] = col;
                getEightQueens(row + 1, columns, result);
            }
        }
    }

    public static boolean isValid(Integer[] columns, int row1, int column1){
        for(int row2 = 0; row2 < row1; row2++){
            int column2 = columns[row2];

            if(column1 == column2)
                return false;

            int colDiff = Math.abs(column1 - column2);
            int rowDiff = row1 - row2;

            if(rowDiff == colDiff)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> out= new ArrayList<>();
        getEightQueens(0,new Integer[8],out);
        System.out.println(out.size());
        for(Integer[] x : out){
            System.out.println(Arrays.deepToString(x));
        }
    }
}
