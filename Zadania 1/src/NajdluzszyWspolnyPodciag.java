import java.util.Scanner;
//similar code to previous one

public class NajdluzszyWspolnyPodciag {
    public static String LongestCommonSubstring(String w1, String w2) {
        int w1Len = w1.length();
        int w2Len = w2.length();
        int totalLen = Math.max(w1Len,w2Len); //max word's length from w1 and w2
        int[] wordIndex = new int[totalLen]; //remembers indexes of w2
        int endIndex = 0; //remembers the last used index
        String commonSequence = ""; //var which returns function's result
        boolean ques = false; //shows if letter is common
        int sgn = 0; //var used as index of table wordIndex
        String tmp = ""; //temporary var for longest sequence

        if (w1==w2) { //if words are exactly the same, we don't need the rest of this function

        return w1;
        }

        for(int q=0; q<w1.length(); q++) {
            for (int i = 0; i < w2.length(); i++) { //fills the table with zeros
                wordIndex[i] = 0;
            }

            for (int i=q; i<w1.length(); i++) {
                for (int j=endIndex; j<w2.length(); j++) { //checks letters after last checked letter
                    ques = true;

                    if (w1.charAt(i)==w2.charAt(j)) { //determines what happens if the w1's letter is same as w2's letter
                        for (int k=0; k<w2.length(); k++) {
                            if (w2.indexOf(w2.charAt(j), j)==wordIndex[k]) {
                                ques = false;
                            }
                        }

                        if (ques==true) {
                            tmp += w1.charAt(i);
                            endIndex = j;

                            wordIndex[sgn] = w2.indexOf(w2.charAt(j), j); //now table remembers index
                            sgn++;
                            break;
                        }
                    }
                }
            }

            if (tmp.length()>commonSequence.length()) { //we have to check if temporary sequence is longer than final
                commonSequence = tmp;
            }

            tmp = ""; //"removes" data from temporary var
            endIndex = 0; //we want to check again, so we have to start from the first letter
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
