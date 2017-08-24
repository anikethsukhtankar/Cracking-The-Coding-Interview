package arraysandstrings;

public class PalindromePermutation {
    private static boolean isPalindromePermutation(String str){
        int[] table = buildCharFreqTable(str);
        return maxOneOddCount(table);
    }

    private static int[] buildCharFreqTable(String str) {
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(char ch : str.toCharArray()){
            int val = getNumericValue(ch);
            if(val != -1) {
                table[val]++;
            }
        }
        return table;
    }

    private static boolean maxOneOddCount(int[] table){
        boolean oddCount = false;
        for(int i : table){
            if(i%2 == 1){
                if(oddCount) {
                    return false;
                }
                oddCount = true;
            }
        }
        return true;
    }

    private static int getNumericValue(char ch){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if(val >= a && val <= z){
            return val - a;
        }
        return -1;
    }

    private static boolean isPalindromePermutationBitVector(String str){
        int bitvector = generateBitVector(str);
        return bitvector == 0 || exactlyOneBitSet(bitvector);
    }

    private static boolean exactlyOneBitSet(int bitvector) {
        return (bitvector & (bitvector - 1)) == 0;
    }

    private static int generateBitVector(String str) {
        int bitvector = 0;
        for(char ch : str.toCharArray()){
            int val = getNumericValue(ch);
            bitvector = toggle(bitvector,val);
        }
        return bitvector;
    }

    private static int toggle(int bitvector, int val) {
        if(val < 0) return bitvector;

        int mask = (1 << val);
        if((bitvector & mask) == 0){
            bitvector |= mask;
        }
        else{
            bitvector &= ~mask;
        }

        return bitvector;
    }

    public static void main(String args[]){
        System.out.println(isPalindromePermutation("taco cat"));
        System.out.println(isPalindromePermutation("taco bat"));
        System.out.println(isPalindromePermutationBitVector("taco cat"));
        System.out.println(isPalindromePermutationBitVector("taco bat"));
    }
}
