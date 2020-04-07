import java.util.Scanner;

public class OdlegloscHamminga {
    public static int Hamming (String firstCode, String secondCode) {
        int hamdist = 0; // var which is returned by function Hamming

        for (int i=0; i<firstCode.length(); i++) { //could be also i<secondCode.length() - their lengths are identical
            if (firstCode.charAt(i) != secondCode.charAt(i)) { // if letter are different Hamming distance increases by 1
                hamdist++;
            } // if the letters are identical, nothing happens
        }

    return hamdist;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        // giving values for Strings
        System.out.println("Write first DNA code:");
        String firstDNA = scan.next();
        System.out.println("Write second DNA code:");
        String secondDNA = scan.next();

        if (firstDNA.length()==secondDNA.length()) {
            int distance = Hamming(firstDNA, secondDNA);
            System.out.println("Hamming distance is " + distance + "!"); // message for user

        } else {
            System.out.println("error");
        }
    }
}
