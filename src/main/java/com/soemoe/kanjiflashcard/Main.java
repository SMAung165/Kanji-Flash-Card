package com.soemoe.kanjiflashcard;

import com.soemoe.kanjiflashcard.services.QuizService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        QuizService quizService = new QuizService(selectLevel(userInput), kanjiCountByUser(userInput));
        userInput.close();
        quizService.startQuiz();
    }

    //core methods
    private static String selectLevel(Scanner userInput) {
        System.out.println("Select JLPT Level");
        System.out.println("-----------------");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%d. N%d\n", i, 6 - i);
        }
        while (true) {
            System.out.print("> ");
            switch (userInput.nextLine()) {
                case "5" -> {
                    return "N1";
                }
                case "4" -> {
                    return "N2";
                }
                case "3" -> {
                    return "N3";
                }
                case "2" -> {
                    return "N4";
                }
                case "1" -> {
                    return "N5";
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    private static int kanjiCountByUser(Scanner userInput) {
        String numberValue;
        while (true) {
            System.out.println("Enter the number Kanji(s) you want to practice");
            System.out.println("----------------------------------------------");
            System.out.print("> ");
            numberValue = userInput.nextLine();
            if (isNumeric(numberValue)) return Integer.parseInt(numberValue);
            System.out.println("Please enter a numeric value!");
        }
    }

    //utility methods
    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
