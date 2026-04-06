package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;

public class KanjiCard extends Flashcard {
    private final String correctReading;
    private ArrayList<String> multipleChoices;
    private int cardNumber = 0;
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

    public int getCardNumber() {
        return cardNumber;
    }

    //setters
    public void setMultipleChoices(ArrayList<String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


}
