import java.util.Scanner;

public class Transkrypcja {
    public static String Transcription(String s) { //changes dna code to rna code
        s = s.replace('T', 'U'); //changes nucleotide with T to nucleotide with U
    return s;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String dna = scan.next();

        dna = dna.toUpperCase(); //provides an opportunity that someone made a mistake while writing dna code and wrote it with a lower case
        String rna = Transcription(dna); //takes result from function Transcription

        System.out.println(rna);
        scan.close();
    }
}
