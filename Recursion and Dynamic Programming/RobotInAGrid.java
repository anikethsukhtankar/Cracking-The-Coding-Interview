package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotInAGrid {
    class Point{
        int row;
        int col;
        Point(int r, int c) {
            row = r;
            col = c;
        }

        public boolean equals(Point b){
            if(b == this)
                return true;

            return (Integer.compare(row, b.row) == 0) && (Integer.compare(col,b.col) == 0);
        }

        public int hashCode(){
            int hash = 7;
            hash = 31 * hash + row + col;
            return hash;
        }
    }

    public ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0) return null;
        ArrayList<Point> res = new ArrayList<>();
        HashMap<Point,Boolean> map = new HashMap<>();
        if(getPath(maze,maze.length-1,maze[0].length-1,res,map)){
            return res;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int r, int c, ArrayList<Point> res, HashMap<Point, Boolean> map) {
        if(r < 0 || c < 0 || !maze[r][c])
            return false;

        Point p = new Point(r,c);

        if(map.containsKey(p))
            return map.get(p);

        boolean isOrigin = (r == 0 && c == 0);
        boolean success = false;

        if(isOrigin || getPath(maze,r-1,c,res,map) || getPath(maze,r,c-1,res,map)){
            res.add(p);
            success = true;
        }

        map.put(p,success);
        return success;
    }

    public static void main(String[] args) {
        RobotInAGrid rb = new RobotInAGrid();
        boolean[][] maze = new boolean[][]{{true,false,false,false,false},{true,true,false,false,false},
                {false,true,true,false,false},{false,false,true,true,false},{false,false,false,true,true}};
        ArrayList<Point> out = rb.getPath(maze);
        if(out == null) System.out.println("No Path Exists");
        else {
            for (Point p : out) {
                System.out.println(p.row + "," + p.col);
            }
        }
    }
}
