import java.util.Scanner;

public class Odwrocone_dopelnienie {
    public static String Complement (String s) {
        s = s.replace('A', '*');
        s = s.replace('T', 'A');
        s = s.replace('*', 'T');
        s = s.replace('C', '#');
        s = s.replace('G', 'C');
        s = s.replace('#', 'G');

    return s;
    }

    public static String Reverse (String s) {
        String s1 = "";

        for (int i=s.length()-1; i>=0; i--) {
            s1 = s1 + s.charAt(i);
        }
    return s1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dna = scan.next();

        dna = dna.toUpperCase(); //adding an opportunity that someone made a mistake while writing dna code
        System.out.println(Reverse(Complement(dna)));

        scan.close();
    }
}
