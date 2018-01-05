package RecursionAndDP;

public class RecursiveMultiply {
    public int getProd(int a, int b){
        int smaller = a < b ? a : b;
        int bigger =  a < b ? b : a;
        return getProdHelper(smaller,bigger);
    }

    public int getProdHelper(int s, int b){
        if(s == 0)
            return 0;
        if(s == 1)
            return b;

        int half = s >> 1;
        int halfProd = getProdHelper(half,b);
        if(s % 2 == 0)
            return halfProd << 1;
        else
            return (halfProd << 1) + b;
    }

    public static void main(String[] args) {
        RecursiveMultiply rm = new RecursiveMultiply();
        System.out.println(rm.getProd(8,7));
    }
}
