package RecursionAndDP;

public class Coins {
    public static int makeChange(int n){
        int[] denoms = {25,10,5,1};
        int[][] map = new int[n+1][denoms.length];
        return makeChange(n,denoms,map,0);
    }

    private static int makeChange(int n, int[] denoms, int[][] map, int i) {
        if(map[n][i] > 0)
            return map[n][i];

        if(i >= denoms.length-1)
            return 1;

        int ways = 0;
        int denomAmt = denoms[i];

        for(int j = 0; j*denomAmt <= n; j++){
            int rem = n - (j*denomAmt);
            ways += makeChange(rem,denoms,map,i+1);
        }

        map[n][i] = ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(makeChange(10));
    }
}
