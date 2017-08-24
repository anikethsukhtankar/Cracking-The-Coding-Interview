package arraysandstrings;

class StringCompression{
    public static String makeCompressed(String str){
        StringBuilder compress = new StringBuilder();
        int count;
        for(int i=0; i< str.length(); i++){
            count = 1;
            while(i+count<str.length() && str.charAt(i+count) == str.charAt(i)){
                count++;
            }
            compress.append(str.charAt(i));
            compress.append(count);
            i = i+count-1;
        }
        return compress.toString().length() < str.length() ? compress.toString():str;
    }

    public static void main(String args[]){
        System.out.println(makeCompressed("aabcccccaaa"));
        System.out.println(makeCompressed("abcca"));
    }
}
