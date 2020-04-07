import java.util.Scanner;

public class NiesmiertelneKroliki {
    public static int immortalRabbits (int k, int n) {
        int rabbitsNumb = 2; // it can be assumed that we have 2 rabbits at the start
        int pairsNumb = 0;

        for (int i=0; i<n; i++) {
            pairsNumb = rabbitsNumb/2; // number of parents' pairs
            rabbitsNumb += pairsNumb*k; // sum of previous rabbits and the new ones
        }

    return rabbitsNumb;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the number of new born rabbits from each parents per one cycle: ");
        int newBorns = scan.nextInt();
        System.out.println("Write how many reproductions would you like to make: ");
        int reproductCtr = scan.nextInt();

        int population = immortalRabbits(newBorns, reproductCtr);
        System.out.println("After " + reproductCtr + "reproductions there are " + population + " rabbits."); // message for user
    }
}
