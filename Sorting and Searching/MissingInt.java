package SortingAndSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {
    public static int findMiss(String filename) throws FileNotFoundException {
        int rangeSize = 1<<20;
        int[] blocks = getBlockSizes(filename,rangeSize);

        int blockIndex = getBlockWithMissingInt(blocks,rangeSize);
        if(blockIndex < 0)
            return -1;

        byte[] bitvector = getBitVector(filename,blockIndex,rangeSize);

        int offset = findZeroBitVector(bitvector);
        if(offset < 0)
            return -1;

        return blockIndex * rangeSize + offset;
    }

    private static int findZeroBitVector(byte[] bitvector) {
        for(int i=0; i<bitvector.length; i++){
            for(int j=0; j<8; j++){
                if((bitvector[i] & (1<<j)) == 0)
                    return i*8+j;
            }
        }
        return -1;
    }

    private static byte[] getBitVector(String filename, int blockIndex, int rangeSize) throws FileNotFoundException {
        int startRange = blockIndex*rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitvector = new byte[rangeSize/8];

        Scanner sc = new Scanner(new FileReader(filename));
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            if(i >= startRange && i<endRange){
                int offset = i-startRange;
                bitvector[offset/8] |= 1<< (offset%8);
            }
        }
        sc.close();
        return bitvector;
    }

    private static int getBlockWithMissingInt(int[] blocks, int rangeSize) {
        for(int i=0; i<blocks.length; i++){
            if(blocks[i] < rangeSize)
                return i;
        }
        return -1;
    }

    private static int[] getBlockSizes(String filename, int rangeSize) throws FileNotFoundException {
        int[] blocks = new int[(Integer.MAX_VALUE/rangeSize) + 1];

        Scanner sc = new Scanner(new FileReader(filename));
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            blocks[i/rangeSize]++;
        }
        sc.close();
        return blocks;
    }


}
