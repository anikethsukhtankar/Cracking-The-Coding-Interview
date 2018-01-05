package RecursionAndDP;

public class MagicIndex {
    public int magicIndex(int[] a){
        return magicBin(a,0,a.length-1);
    }

    public int magicBin(int[] a, int l, int h){
        if(l > h)
            return -1;
        int m = (l+h)/2;
        if(a[m] == m)
            return m;
        else if(a[m] > m) {
            int left = magicBin(a, l, m - 1);
            if(left > -1) return left;
            int right = magicBin(a, a[m], h);
            return right;
        }
        else {
            int left = magicBin(a, l, a[m]);
            if(left > -1) return left;
            int right = magicBin(a, m + 1, h);
            return right;
        }
    }

    public static void main(String[] args) {
        MagicIndex mi = new MagicIndex();
        System.out.println(mi.magicIndex(new int[]{-10,-5,2,2,2,3,4,7,9,12,13}));
    }
}
