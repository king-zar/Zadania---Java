import java.util.Scanner;

public class NajdluzszyWspolnyPodciag {
    public static String LongestCommonSubstring(String w1, String w2) {
        int w1Len = w1.length();
        int w2Len = w2.length();
        int totalLen = Math.max(w1Len,w2Len); //max word's length from w1 and w2
        int[] wordIndex = new int[totalLen]; //remembers indexes of w2
        int endIndex = 0; //remembers the last used index
        String commonSequence = "";
        boolean ques = true;
        int sgn = 0; //var used as index of table wordIndex
        String tmp = "";

        if (w1==w2) { //if words are exactly the same, we don't need the rest of this function

        return w1;
        }

        for(int q=0; q<w1.length(); q++) {
            for (int i = 0; i < w2.length(); i++) { //fills the table with zeros
                wordIndex[i] = 0;
            }

            for (int i=q; i<w1.length(); i++) {
                for (int j=endIndex; j<w2.length(); j++) {
                    ques = true;

                    if (w1.charAt(i)==w2.charAt(j)) {
                        for (int k=0; k<w2.length(); k++) {
                            if (w2.indexOf(w2.charAt(j), j)==wordIndex[k]) {
                                ques = false;
                            }
                        }

                        if (ques==true) {
                            tmp += w1.charAt(i);
                            endIndex = j;

                            wordIndex[sgn] = w2.indexOf(w2.charAt(j), j);
                            sgn++;
                            break;
                        }
                    }
                }
            }

            if (tmp.length()>commonSequence.length()) {
                commonSequence = tmp;
            }

            tmp = "";
            endIndex = 0;
            sgn = 0;
        }

    return commonSequence;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String word1 = scan.next();
        String word2 = scan.next();

        //changing words' letters to lower cases
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        String result = LongestCommonSubstring(word1, word2);
        System.out.println(result); //takes the result from function LongestCommonSubstring and writes the longest substring
        scan.close();
    }
}
