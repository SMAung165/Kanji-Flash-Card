package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;

public abstract class Flashcard {
    protected String word;
    protected String meaning;

    //constructor
    public Flashcard(String words, String meaning) {
        this.word = words;
        this.meaning = meaning;
    }

    //getters
    public String getWord() {
        return word;
    }
    public String getMeaning() {
        return meaning;
    }


    //methods
    public abstract void showCard();

    public abstract void showMultipleChoices(ArrayList<String> choices);
}
