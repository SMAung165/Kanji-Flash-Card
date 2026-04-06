package com.soemoe.kanjiflashcard.services;
import com.soemoe.kanjiflashcard.models.KanjiCard;
import com.soemoe.kanjiflashcard.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizUI {
    private final Scanner userInput;

    //constructors
    public QuizUI() {
        userInput = new Scanner(System.in);
    }

    //getters
    public String getLevel() {
        return selectLevel(userInput);
    }

    public int getKanjiCount() {
        return kanjiCountByUser(userInput);
    }

    public String getUserAnswer() {
        System.out.print("Your answer: ");
        return userInput.nextLine();
    }

    //methods
    private String selectLevel(Scanner userInput) {
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

    private int kanjiCountByUser(Scanner userInput) {
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

    public void showCard(KanjiCard card) {
        System.out.println("----------------------------------------------");
        System.out.printf("Kanji: %s\n", card.getWord());
        System.out.printf("Meaning: %s\n", card.getMeaning());
        System.out.printf("Card No. %d\n", card.getCardNumber());
    }

    public void showMultipleChoices(KanjiCard card) {
        Collections.shuffle(card.getMultipleChoices());
        for (int i = 0; i < card.getMultipleChoices().size(); i++) {
            System.out.printf("%d. %s \n", i + 1, card.getMultipleChoices().get(i));
        }
    }

    public void responseUserAnswer(boolean isCorrect) {
        System.out.println(
                isCorrect ? "Your answer is correct!" : "Your answer is incorrect!"
        );
    }

    public void invalidUserInput() {
        System.out.println("Invalid Input!");
    }

    public void showResults(int score, int mistakes) {
        System.out.println("----------------------------------------------");
        System.out.println("Correct: " + score);
        System.out.println("Incorrect: " + (mistakes));
        if (score > mistakes) {
            System.out.println("偉い、よくやった！");
        } else {
            System.out.println("ちゃんと勉強しろ!!");
        }
        System.out.println("----------------------------------------------");
    }

    public void showMistakes(ArrayList<KanjiCard> incorrectCards) {
        System.out.println("----------------------------------------------");
        System.out.println("📝 Review Your Mistakes: ");
        System.out.println("----------------------------------------------");
        for (KanjiCard incorrectCard : incorrectCards) {
            showCard(incorrectCard);
            System.out.println("You answered -> " + incorrectCard.getUserChoice());
            System.out.println("Correct Reading -> " + incorrectCard.getCorrectReading());
        }
    }

}
