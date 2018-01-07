package RecursionAndDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {
    static class Box{
        int height;
        int width;
        int length;
        Box(int height,int width,int length){
            this.height = height;
            this.width = width;
            this.length = length;
        }

        public boolean canBeAbove(Box bottom) {
            return this.height > bottom.height && this.length > bottom.length && this.width > bottom.width;
        }

        @Override
        public String toString(){
            return String.valueOf(height);
        }
    }

    static class BoxComparator implements Comparator<Box>{

        @Override
        public int compare(Box o1, Box o2) {
            return o1.height - o2.height;
        }
    }

    public static int placeBoxes(ArrayList<Box> boxes){
        if(boxes == null || boxes.size() == 0) return 0;
        Collections.sort(boxes, new BoxComparator());
        System.out.println(boxes);
        int maxHeight = 0;
        int[] map = new int[boxes.size()];

        for(int i = 0; i < boxes.size(); i++){
            int height = createStack(boxes,i,map);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int i, int[] map) {
        if(i < boxes.size() && map[i] > 0)
            return map[i];

        Box bottom = boxes.get(i);
        int maxHeight = 0;
        for(int j = i+1; j<boxes.size(); j++ ){
            if(boxes.get(j).canBeAbove(bottom)) {
                int height = createStack(boxes, j, map);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        map[i] = maxHeight;
        return maxHeight;
    }

    public static void main(String[] args) {
        ArrayList<Box> input = new ArrayList<Box>(){{
            add(new Box(1,1,1));
            add(new Box(2,2,2));
            add(new Box(3,3,1));
        }};
        System.out.println(placeBoxes(input));
    }
}
