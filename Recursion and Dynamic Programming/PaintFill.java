package RecursionAndDP;

import java.util.Arrays;

import static RecursionAndDP.PaintFill.Color.Black;
import static RecursionAndDP.PaintFill.Color.Green;
import static RecursionAndDP.PaintFill.Color.White;

public class PaintFill {
    public enum Color{Black,White,Red,Green,Blue}

    private static boolean paintFill(Color[][] screen, int r, int c, Color ncolor){
        if(screen[r][c] == ncolor) return false;
        return paintFill(screen,r,c,screen[r][c],ncolor);
    }

    private static boolean paintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if(r < 0 || r >= screen.length || c < 0 || c >=screen[0].length)
            return false;

        if(screen[r][c] == ocolor){
            screen[r][c] = ncolor;
            paintFill(screen,r-1,c,ocolor,ncolor);
            paintFill(screen,r+1,c,ocolor,ncolor);
            paintFill(screen,r,c-1,ocolor,ncolor);
            paintFill(screen,r,c+1,ocolor,ncolor);
        }

        return true;
    }

    public static void main(String[] args) {
        Color[][] scr = new Color[][]{{Black},{Green},{Green},{White}};
        paintFill(scr,1,0,White);
        System.out.println(Arrays.deepToString(scr));
    }
}
