package com.soemoe.kanjiflashcard;

import com.soemoe.kanjiflashcard.services.QuizService;
import com.soemoe.kanjiflashcard.utils.ValidationUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        QuizService quizService = new QuizService(selectLevel(userInput), kanjiCountByUser(userInput));
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
                    return "n1";
                }
                case "4" -> {
                    return "n2";
                }
                case "3" -> {
                    return "n3";
                }
                case "2" -> {
                    return "n4";
                }
                case "1" -> {
                    return "n5";
                }
                default -> System.out.println("Invalid input");
            }
        }
    }


    private static int kanjiCountByUser(Scanner userInput) {
        String numberValue;
        while (true) {
            System.out.println("Enter the number Kanji(s) you want to practice.");
            System.out.println("----------------------------------------------");
            System.out.print("> ");
            numberValue = userInput.nextLine();
            if (ValidationUtils.isNumeric(numberValue)) {
                if (Integer.parseInt(numberValue) > 0) {
                    return Integer.parseInt(numberValue);
                } else {
                    System.out.println("Please enter a number greater than 0.");
                    continue;
                }
            }
            System.out.println("Please enter an integer value!");
        }
    }
}
