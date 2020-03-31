import java.util.Scanner;

public class NajdluzszyWspolnyPodlancuch {
    public static String LongestCommonSubstring (String w1, String w2) { //checking the longest common substring
        String tmp1 = ""; //temporary var for changing words - shorter/longer inside if in 16 line
        String tmp = ""; //temporary var which remembers chain
        String commonChain = ""; //is returned by this function
        int index = 0; //remembers the "index" of the letter
        boolean check = false; //shows if letter is common

        if (w1==w2) { //if words are exactly the same, we don't need the rest of this function

        return w1;
        }

        if (w1.length()<w2.length()) { //we have to check which word is longer (longer word should be in the first "for" below
            tmp1 = w1;
            w1 = w2;
            w2 = tmp1;
        }

        for (int i=0; i<w1.length(); i++) { //checks longer word's letters
            for (int j=0; j<w2.length(); j++) { //checks shorter word's letters
                if (w1.charAt(i)==w2.charAt(j)) {
                    if (check==false) { //increases index, because of need to remember the letter of longer word that we will check next
                        index = i+1;

                        if (index==w1.length()) {
                            index = i;
                        }
                    }

                    tmp += w2.charAt(j); //increases temporary string ("memory")

                    if (i+1<w1.length()) { //if w1 were longer, it wouldn't make sense to check next letters
                        i++;
                    }

                    check = true;

                } else {
                    if (check==true) { //only if previous last letter belongs to chain
                        check = false; //returns to initial situation
                        i = index;

                        if (tmp.length()>commonChain.length()) { //checks which substring is longer
                            commonChain = tmp;
                        }

                        tmp = ""; //"removes" data from temporary var
                    }
                    //if previous checked letter doesn't belong to chain, it won't happen anything except for j++
                }
            }

            if (check==true) {  //exactly the same as at the end of for (j), but it happens if the shorter word ended
                check = false;
                i = index;

                if (tmp.length()>commonChain.length()) {
                    commonChain = tmp;
                }

                tmp = "";

                //if previous checked letter doesn't belong to chain, it won't happen anything except for i++
            }
        }

    return commonChain;
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
