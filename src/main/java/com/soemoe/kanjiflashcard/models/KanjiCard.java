package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;
import java.util.Collections;

public class KanjiCard extends Flashcard {
    private String correctReading;
    private String jlptLevel;

    //constructors
    public KanjiCard(String word, String meaning, String correctReading) {
        super(word, meaning);
        this.correctReading = correctReading;
    }

    //getters
    public String getCorrectReading() {
        return correctReading;
    }

    //methods
    @Override
    public void showCard() {
        System.out.println("------------------------------------");
        System.out.printf("Kanji: %s\n", word);
        System.out.printf("Meaning: %s\n", meaning);
    }

    @Override
    public void showMultipleChoices(ArrayList<String> choices) {
        Collections.shuffle(choices);
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, choices.get(i));
        }
    }

}
