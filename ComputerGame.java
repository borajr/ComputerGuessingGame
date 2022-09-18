import java.util.*; // For sc, Random, etc.

/**
 * 
 * 
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher"
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * 
 * @author Bora Kaplan
 * @id 1731383
 * @author Ege Ozkan
 * @1795708
 * @17.09.2022
 */
public class ComputerGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;

    void run() {
        // TODO: Implementation

        System.out.println(
                "Think of a secret number not smaller than 0"
                        + "and not greater than 999. Type 'go' when you have thought");

        sc.nextLine(); // scanner detecs "go" to start the game

        int min = 0; // lower boundary
        int max = 999; // upper boundary

        int counter = 0; // counter used to count game rounds
        boolean done = false;
        while (!done) { // loop while game is not finished

            int guess = min + ((max - min) / 2);
            // random number generator for computer guesses

            System.out.println("My guess is: " + guess);

            String answer = sc.nextLine();

            if (answer.equals("lower")) { // conditioning the lower answer
                max = guess - 1;
                counter += 1; // increase counter to count 10 rounds
            } else if (answer.equals("higher")) { // conditioning the higher answer
                min = guess + 1;
                counter += 1; // increase counter to count 10 rounds
            } else {
                done = true; // terminates the game
            }
            if (counter == 10) { // checking whether computer should give up
                System.out.println("I give up");
                break; // breaks the loop
            }
        }
        sc.close();
    }

    // END TODO

    public static void main(String[] args) {
        new ComputerGame().run();
    }
}
