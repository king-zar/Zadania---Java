import java.util.Scanner;

public class ZliczanieNukleotydow {
    public static int[] Quantity(String s) { //function for counting nucleotides
        int[] quan = new int[4];

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'A') { //counts nucleotides with A
                quan[0]++;
            } else if (s.charAt(i) == 'C') { //counts nucleotides with C
                quan[1]++;
            } else if (s.charAt(i) == 'G') { //counts nucleotides with G
                quan[2]++;
            } else if (s.charAt(i) == 'T') { //counts nucleotides with T
                quan[3]++;
            }
        }

    return quan;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String dna = scan.next();

        dna = dna.toUpperCase(); //provides an opportunity that someone made a mistake while writing dna code and wrote it with a lower case
        int[] amount = new int[4];
        amount = Quantity(dna); //takes results from Quantity

        //now program prints results of function Quantity
        System.out.printf("%s%d%n", "#A: ", amount[0]);
        System.out.printf("%s%d%n", "#C: ", amount[1]);
        System.out.printf("%s%d%n", "#G: ", amount[2]);
        System.out.printf("%s%d%n", "#T: ", amount[3]);
        scan.close();
    }
}
