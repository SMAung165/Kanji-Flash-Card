package com.soemoe.kanjiflashcard.models;

import com.soemoe.kanjiflashcard.services.KanjiDatabase;

import java.util.ArrayList;

public class KanjiCard extends Flashcard {
    private String correctReading;
    private String jlptLevel;

    //constructors
    public KanjiCard() {
        this(null, null, null, null);
    }

    public KanjiCard(String word, String meaning, String correctReading, String jlptLevel) {
        super(word, meaning);
        this.correctReading = correctReading;
        this.jlptLevel = jlptLevel;
    }

    //getters
    public String getCorrectReading() {
        return correctReading;
    }

    public String getJlptLevel() {
        return jlptLevel;
    }

    //setters
    public void setupKanjiCard(String word, String meaning, String correctReading) {
        this.correctReading = correctReading;
        this.meaning = meaning;
        this.word = word;
    }

    //methods
    @Override
    public void showCard() {
        System.out.printf("Kanji: %s\n", word);
        System.out.printf("Meaning: %s\n", meaning);
    }

    @Override
    public void showMultipleChoices(ArrayList<String> choices) {
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, choices.get(i));
        }
    }



}
