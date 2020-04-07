import java.util.Random;
import java.util.Scanner;

public class SmiertelneKroliki {
    public static int mortalRabbits (int k, int n, int m) {
        // we have one male rabbit and one female rabbit at the start, this numbers'll be modified
        int maleNumb = 1;
        int femaleNumb = 1;

        // new borns in one cycle
        int newBornMale;
        int newBornFemale;

        int[][] mortality; // tab which has information about new rabbits per cycle
        mortality = new int[2][m + 1]; // 2 -> males&females, m+1 because we have m cycles and we have to know number after the cycle
        mortality[0][0] = 1; // line 0 is dedicated to males
        mortality[1][0] = 1; // line 1 is dedicated to females

        int pairNumb = 1; // we have one pair at the start, it'll be modified

        for (int i = 1; i <= n; i++) { //n cycles, so loop determines, what happens in one cycle
            // firstly when comes the time, we have to remove dead rabbits from population
            if (i > 2)
                if (i % (m + 1) == 0) {
                    maleNumb -= mortality[0][0];
                    femaleNumb -= mortality[1][0];

                } else if (i % (m + 1) == 1) {
                    maleNumb -= mortality[0][1];
                    femaleNumb -= mortality[1][1];

                } else if (i % (m + 1) == 2) {
                    maleNumb -= mortality[0][2];
                    femaleNumb -= mortality[1][2];
                }
            // removing old information about new borns
            newBornMale = 0;
            newBornFemale = 0;

            // determining number of pairs which still exists and can procreate
            if (maleNumb==femaleNumb || maleNumb<femaleNumb) {
                pairNumb = maleNumb;

            } else if (femaleNumb<maleNumb) {
                pairNumb = femaleNumb;
            }

            // gender is random for each cycle
            for (int j=0; j<pairNumb*k; j++) { // programme randomizes gender for each new born rabbit
                Random lottery = new Random();

                if (lottery.nextBoolean() == false) { // we want to remember new borns, because we'll place them in mortality tab
                    maleNumb++;
                    newBornMale++;

                } else {
                    femaleNumb++;
                    newBornFemale++;
                }
            }

            mortality[0][i%(m+1)] = newBornMale;
            mortality[1][i%(m+1)] = newBornFemale;
        }


        int rabbitsNumb = maleNumb + femaleNumb;
    return rabbitsNumb;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the number of new born rabbits from each parents per one cycle: ");
        int newBorns = scan.nextInt();
        System.out.println("Write how many reproductions would you like to make: ");
        int reproductCtr = scan.nextInt();
        System.out.println("Write how long should each rabbit exist: ");
        int rabExist = scan.nextInt();

        int population = mortalRabbits(newBorns, reproductCtr, rabExist);
        System.out.println("After " + reproductCtr + "reproductions there are " + population + " rabbits."); // message for user
    }
}
