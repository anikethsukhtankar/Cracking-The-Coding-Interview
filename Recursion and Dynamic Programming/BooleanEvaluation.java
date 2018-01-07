package RecursionAndDP;

import java.util.HashMap;

public class BooleanEvaluation {
    public static int countEval(String s, boolean result, HashMap<String,Integer> map){
        if(s.length() == 0) return 0;
        if(s.length() == 1) return stringToBool(s) == result ? 1 : 0;
        if(map.containsKey(String.valueOf(result) + s)) return map.get(String.valueOf(result) + s);

        int ways = 0;
        for(int i=1; i<s.length(); i+=2){
            char c = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);

            int leftTrue = countEval(left,true,map);
            int rightTrue = countEval(right,true,map);
            int leftFalse = countEval(left,false,map);
            int rightFalse = countEval(right,false,map);

            int totalEval = (leftTrue+leftFalse) * (rightTrue+rightFalse);

            int totalTrue = 0;
            switch (c){
                case '^' : totalTrue += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                           break;
                case '&' : totalTrue += (leftTrue * rightTrue);
                           break;
                case '|' : totalTrue += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                           break;
            }

            int subways = result ? totalTrue : totalEval-totalTrue;
            ways += subways;
        }

        map.put(String.valueOf(result) + s,ways);
        return ways;
    }

    private static boolean stringToBool(String s) {
        return s.equals("1") ? true:false;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> cache = new HashMap<>();
        System.out.println(countEval("0&0&0&1^1|0",true,cache));
    }
}
