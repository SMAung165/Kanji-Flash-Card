package com.soemoe.kanjiflashcard.models;


public abstract class Flashcard {
    protected String word;
    protected String meaning;

    //constructor
    public Flashcard(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    //getters
    public String getWord() {
        return word;
    }
    public String getMeaning() {
        return meaning;
    }
}
