package com.soemoe.kanjiflashcard;

import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.models.KanjiCard;
import com.soemoe.kanjiflashcard.services.KanjiDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        ArrayList<KanjiCard> kanjiList = deckPreparation(selectLevel(userInput), userInput);
        for (KanjiCard kanjiCard : kanjiList) {
            kanjiCard.showCard();
        }
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

    private static ArrayList<KanjiCard> deckPreparation(String level, Scanner userInput) {
        KanjiDatabase kanjiDatabase = new KanjiDatabase();
        Kanji randomKanji;
        KanjiCard randomKanjiCard;
        ArrayList<KanjiCard> deck = new ArrayList<>();

        System.out.println("Enter the number Kanji(s) you want to practice");
        System.out.println("----------------------------------------------");
        System.out.print("> ");

        int numberOfKanjiByUserInput = Math.min(userInput.nextInt(), kanjiDatabase.getKanjiByLevel(level).size());

        int i = 0;
        while (i != numberOfKanjiByUserInput) {
            randomKanji = getRandomKanjiByLevel(kanjiDatabase, level);
            randomKanjiCard = new KanjiCard(randomKanji.getKanjiChar(), randomKanji.getMeaning(), randomKanji.getKunyomi());

            if (!isKanjiCardDuplicated(randomKanjiCard, deck)) {
                deck.add(randomKanjiCard);
                i++;
            }
        }
        return deck;
    }

    //utility methods
    private static Kanji getRandomKanjiByLevel(KanjiDatabase kanjiDatabase, String level) {
        int randomIndexNumber = (int) (Math.random() * (kanjiDatabase.getKanjiByLevel(level).size()));
        return kanjiDatabase.getKanjiByLevel(level).get(randomIndexNumber);
    }

    private static boolean isKanjiCardDuplicated(KanjiCard checkingKanjiCard, ArrayList<KanjiCard> kanjiList) {
        for (KanjiCard targetKanjiCard : kanjiList) {
            if (checkingKanjiCard.getWord().equals(targetKanjiCard.getWord())) {
                return true;
            }
        }
        return false;
    }

}
