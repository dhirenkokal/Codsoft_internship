package codsoft_task1;

import java.util.Scanner;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int numberToGuess;
        boolean playAgain = true;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain) {
            roundsPlayed++;
            numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + roundsPlayed);
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            boolean hasGuessedCorrectly = false;
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts >= 5) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + numberToGuess);
                    hasGuessedCorrectly = true;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (playAgainResponse.equals("no")) {
                playAgain = false;
            } else if (playAgainResponse.equals("yes")) {
                attempts = 0;
            } else {
                System.out.println("Invalid response. Game over.");
                playAgain = false;
            }
        }

        double averageAttempts = (double) totalAttempts / roundsPlayed;
        System.out.println("Thank you for playing! Your average number of attempts was: " + averageAttempts);
        scanner.close();
    }
}
