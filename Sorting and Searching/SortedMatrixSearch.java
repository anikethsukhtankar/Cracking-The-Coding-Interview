package SortingAndSearching;

public class SortedMatrixSearch {
    public static boolean findElementSimple(int[][] matrix, int elem){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == elem)
                return true;
            else if(matrix[row][col] > elem)
                col--;
            else
                row++;
        }
        return false;
    }

    static class Coordinate implements Cloneable{
        int row,col;

        Coordinate(int r,int c){
            row = r;
            col = c;
        }

        public Object clone(){
            return new Coordinate(this.row,this.col);
        }

        public boolean isBefore(Coordinate p){
            return this.row <= p.row && this.col <= p.col;
        }

        public boolean inbounds(int[][] matrix){
            return row>=0 && row<matrix.length && col >=0 && col <matrix[0].length;
        }

        public void setToAverage(Coordinate min, Coordinate max){
            this.row = (min.row + max.row)/2;
            this.col = (min.col + max.col)/2;
        }

        public String toString(){
            return "Row: "+ this.row + "," + "Column: " + this.col;
        }

    }

    public static Coordinate findElement(int[][] matrix, int x){
        Coordinate origin = new Coordinate(0,0);
        Coordinate dest = new Coordinate(matrix.length-1,matrix[0].length-1);
        return findElement(matrix,origin,dest,x);
    }

    private static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
        if(!origin.inbounds(matrix) || !dest.inbounds(matrix))
            return null;
        else if(matrix[origin.row][origin.col] == x)
            return origin;
        else if(!origin.isBefore(dest))
            return null;

        Coordinate start = (Coordinate) origin.clone();
        int diagDist = Math.min(dest.col - origin.col,dest.row - origin.row);
        Coordinate end = new Coordinate(start.row + diagDist, start.col + diagDist);
        Coordinate p = new Coordinate(0,0);

        while(start.isBefore(end)){
            p.setToAverage(start,end);
            if(x > matrix[p.row][p.col]){
                start.row = p.row+1;
                start.col = p.col+1;
            }
            else{
                end.row = p.row-1;
                end.col = p.col-1;
            }
        }

        return partitionAndSearch(matrix,origin,dest,start,x);
    }

    private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x) {
        Coordinate leftOrigin = new Coordinate(pivot.row,origin.col);
        Coordinate leftDest = new Coordinate(dest.row,pivot.col-1);
        Coordinate rightOrigin = new Coordinate(origin.row,pivot.col);
        Coordinate rightDest = new Coordinate(pivot.row-1,dest.col);

        Coordinate lowerLeft = findElement(matrix,leftOrigin,leftDest,x);
        if(lowerLeft == null){
            return findElement(matrix,rightOrigin,rightDest,x);
        }
        return lowerLeft;

    }

    public static void main(String[] args) {
        int[][] input = {{15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,120,120}};
        System.out.println(findElement(input,105));
    }
}
