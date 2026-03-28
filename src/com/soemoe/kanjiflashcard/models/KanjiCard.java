package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;

public class KanjiCard extends Flashcard {
    private String correctReading;
    private String jlptLevel;

    //constructors
    public KanjiCard(String word, String meaning, String correctReading, String jlptLevel) {
        super(word, meaning);
        this.correctReading = correctReading;
        this.jlptLevel = jlptLevel;
    }

    //getters
    public String getCorrectReading() {
        return correctReading;
    }

    //methods
    @Override
    public void showCard() {
        System.out.printf("Kanji: %s\n", word);
        System.out.printf("Meaning: %s\n", meaning);
    }

    @Override
    public void showMultipleChoices(ArrayList<String> choices) {
        for (int i = 1; i <= choices.size(); i++) {
            System.out.printf("%d. %s \n", i, choices.get(i));
        }
    }
}
