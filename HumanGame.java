import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.Scanner;

import javax.xml.transform.Source;

/**
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Bora Kaplan, Ege Ozkan
 * @id 1781383
 * @Ege Ozkan
 * @1795708
 * @18.09.2022
 */
public class HumanGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator = new Random();

    void run() {
        // TODO: Implementation
        long seed; // actually read from input 12323434
        System.out.println("Type an arbitrary number: ");
        seed = sc.nextLong();
        randomGenerator = new Random(seed);

        int numberToBeGuessed = randomGenerator.nextInt(99); // creates the random number
        int usersGuess;
        System.out.println("Start guessing!");

        int counter = 0; // counter used to track game rounds
        String dots = "............................"
                + ".......................................................................";
        String[] dotValueHolder = new String[7];
        int[] guessHistory = new int[6]; // an array to append guesses every round
        int guessValueHolder; // temporary variable to hold guess values of user
        int increment = 0; // used to add index in the array

        while (sc.hasNextLine()) {
            usersGuess = sc.nextInt(); // reads integer input scanner
            guessValueHolder = usersGuess;

            if (numberToBeGuessed > usersGuess) { // checking higher values
                System.out.println("Higher");
                dotValueHolder[counter] = dots.substring(1, usersGuess) + "X"
                        + dots.substring(usersGuess + 1, numberToBeGuessed) + "|"
                        + dots.substring(numberToBeGuessed, 99);
                counter += 1;
            } else if (numberToBeGuessed < usersGuess) { // checking lower values
                System.out.println("Lower");
                dotValueHolder[counter] = dots.substring(1, numberToBeGuessed) + "|"
                        + dots.substring(numberToBeGuessed + 1, usersGuess) + "X"
                        + dots.substring(usersGuess, 99);
                counter += 1;
            } else if (numberToBeGuessed == usersGuess) { // winning condition check
                System.out.println("Good guess! You Won.");
                System.out.println((counter + 1) + " Guesses: ");

                do {
                    for (int i = 0; i < dotValueHolder.length; i++) {
                        if (dotValueHolder[i] != null) {
                            System.out.println(dotValueHolder[i]);
                        } else {
                            continue;
                        }
                    }
                } while (usersGuess != numberToBeGuessed);
                System.out.println(dots.substring(1, numberToBeGuessed)
                        + "X" + dots.substring(numberToBeGuessed, 99));

            }

            if (counter == 7) { // losing condition check
                System.out.println("No more guesses, you lost.");
                System.out.println(counter + " Guesses:");

                for (int guess = 0; guess < guessHistory.length; guess++) {

                    if (numberToBeGuessed < guessHistory[guess]) {
                        System.out.println(dots.substring(1, numberToBeGuessed) + "|"
                                + dots.substring(numberToBeGuessed + 1, guessHistory[guess])
                                + "X" // inserts the required X and | signs between values
                                + dots.substring(guessHistory[guess], 99));
                    } else {
                        System.out.println(
                                dots.substring(1, guessHistory[guess]) + "X"
                                        + dots.substring(guessHistory[guess] + 1, numberToBeGuessed)
                                        + "|" // inserts the required X and | signs between values
                                        + dots.substring(numberToBeGuessed, 99));

                    }
                }

                break;

            }
            guessHistory[increment] = guessValueHolder; // adds inputs to the array
            increment += 1;

        }

        // END TODO
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
