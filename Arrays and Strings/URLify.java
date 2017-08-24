package arraysandstrings;

public class URLify {
    public static String urlify(String s, int trueLength){
        char[] str = s.toCharArray();
        int spaceCount = 0, index, i;
        for(i=0; i<trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount*2;
        if(index < s.length()) str[index] = '\0';
        for(i=trueLength-1; i>=0; i--){
            if(str[i]==' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index -= 3;
            }
            else{
                str[index-1] = str[i];
                index--;
            }
        }
        return new String(str);
    }

    public static void main(String args[]){
        String ans = urlify("Mr John Smith    ",13);
        System.out.println(ans);
    }

}
