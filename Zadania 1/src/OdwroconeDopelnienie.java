import java.util.Scanner;

public class Odwrocone_dopelnienie {
    public static String Complement (String s) {
        //changing nucleotides to complementary ones
        s = s.replace('A', '*');
        s = s.replace('T', 'A');
        s = s.replace('*', 'T');
        s = s.replace('C', '#');
        s = s.replace('G', 'C');
        s = s.replace('#', 'G');

    return s;
    }

    public static String Reverse (String s) { //reverse the code
        String s1 = "";

        for (int i=s.length()-1; i>=0; i--) {
            s1 = s1 + s.charAt(i);
        }
    return s1;
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String dna = scan.next();

        dna = dna.toUpperCase(); //provides an opportunity that someone made a mistake while writing dna code and wrote it with a lower case
        System.out.println(Reverse(Complement(dna))); //prints the result of function Complement

        scan.close();
    }
}
