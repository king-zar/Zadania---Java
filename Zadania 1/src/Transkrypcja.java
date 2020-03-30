import java.util.Scanner;

public class Transkrypcja {
    public static String Transcription(String s) {
        s = s.replace('T', 'U');
    return s;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String dna = scan.next();
        String rna = Transcription(dna);
        scan.close();
        System.out.println(rna);
    }
}
