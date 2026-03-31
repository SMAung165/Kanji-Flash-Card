package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;
import java.util.Collections;

public class KanjiCard extends Flashcard {
    private final String correctReading;
    private ArrayList<String> multipleChoices;
    private String userChoice;

    //constructors
    public KanjiCard(String word, String meaning, String correctReading) {
        super(word, meaning);
        this.correctReading = correctReading;
    }

    //getters
    public String getCorrectReading() {
        return correctReading;
    }

    public ArrayList<String> getMultipleChoices() {
        return multipleChoices;
    }

    public String getUserChoice() {
        return userChoice;
    }

    //setters
    public void setMultipleChoices(ArrayList<String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    //methods
    @Override
    public void showCard() {
        System.out.println("----------------------------------------------");
        System.out.printf("Kanji: %s\n", getWord());
        System.out.printf("Meaning: %s\n", getMeaning());
    }

    @Override
    public void showMultipleChoices() {
        Collections.shuffle(multipleChoices);
        for (int i = 0; i < multipleChoices.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, multipleChoices.get(i));
        }
    }



}
