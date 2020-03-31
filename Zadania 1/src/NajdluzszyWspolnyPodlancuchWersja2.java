import java.util.Scanner;

public class NajdluzszyWspolnyPodlancuchWersja2 {
    public static String LongestCommonSubstring(String w1, String w2) {
        String commonSequence = ""; //is returned by this function
        int max = 0;
        int endIndex = 0;
        int w1Len = w1.length();
        int w2Len = w2.length();
        int totalLen = Math.max(w1Len,w2Len)+1;
        int[][] index = new int [totalLen][totalLen];

        if (w1==w2) { //if words are exactly the same, we don't need the rest of this function

            return w1;
        }

        for (int i=0; i<totalLen; i++) {
            index[i][0] = 0;
            index[0][i] = 0;
        }
        for (int i=1; i<=w1Len; i++) {
            for (int j=1; j<=w2Len; j++) {
                if (w1.charAt(i-1)!=w2.charAt(j-1)) {
                    index[i][j] = 0 ;

                } else {
                    index[i][j] = index[i-1][j-1]+1;

                    if (index[i][j]>max) {
                        max = index[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        commonSequence = w1.substring(endIndex-max, endIndex);

        return commonSequence;
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String word1 = scan.next();
        String word2 = scan.next();

        //changing letters in words to lower cases
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        System.out.println(LongestCommonSubstring(word1, word2)); //takes the result from function LongestCommonSubstring and writes the longest substring
        scan.close();
    }
}