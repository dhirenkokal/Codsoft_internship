package codsoft_task3;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class task3 {
    static int score = 0;
    static int currentQuestionIndex = 0;
    static String[][] quizData = {
        {"What is the capital of France?", "A. Berlin", "B. London", "C. Paris", "D. Madrid", "C"},
        {"Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "B"},
        {"Which gas do plants absorb from the atmosphere?", "A. Oxygen", "B. Carbon Dioxide", "C. Hydrogen", "D. Nitrogen", "B"},
        {"What is the largest mammal in the world?", "A. African Elephant", "B. Blue Whale", "C. Giraffe", "D. Polar Bear", "B"},
        {"Who wrote the play 'Romeo and Juliet'?", "A. Charles Dickens", "B. William Shakespeare", "C. Mark Twain", "D. Jane Austen", "B"},
        {"In which year did Christopher Columbus discover America?", "A. 1492", "B. 1510", "C. 1620", "D. 1776", "A"},
        // Add more questions and options here
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz App!");
        System.out.println("You have 15 seconds to answer each question. Enter the letter (A, B, C, or D) of your choice.");

        askNextQuestion(scanner);

        // Close the scanner and exit the program when done
        scanner.close();
    }

    static void askNextQuestion(Scanner scanner) {
        if (currentQuestionIndex < quizData.length) {
            String[] question = quizData[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + question[0]);
            for (int i = 1; i < question.length - 1; i++) {
                System.out.println(question[i]);
            }

            String correctAnswer = question[question.length - 1];
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! The correct answer is " + correctAnswer);
                    currentQuestionIndex++;
                    timer.cancel(); // Cancel the timer for this question
                    askNextQuestion(scanner);
                }
            }, 15000);

            String userAnswer = scanner.nextLine().trim().toUpperCase();
            timer.cancel(); // Cancel the timer

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswer);
            }

            currentQuestionIndex++;
            askNextQuestion(scanner);
        } else {
            displayResult();
        }
    }

    static void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + " out of " + quizData.length);

        // You can add more details, such as correct/incorrect answers and explanations here.

        System.exit(0);
    }
}
