package com.soemoe.kanjiflashcard.models;

import java.util.ArrayList;
import java.util.Collections;

public class KanjiCard extends Flashcard {
    private final String correctReading;
    private ArrayList<String> multipleChoices;

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

    //setters
    public void setMultipleChoices(ArrayList<String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    //methods
    @Override
    public void showCard() {
        System.out.println("------------------------------------");
        System.out.printf("Kanji: %s\n", word);
        System.out.printf("Meaning: %s\n", meaning);
    }

    @Override
    public void showMultipleChoices() {
        Collections.shuffle(multipleChoices);
        for (int i = 0; i < multipleChoices.size(); i++) {
            System.out.printf("%d. %s \n", i + 1, multipleChoices.get(i));
        }
    }

    public String getUserChoice(int indexNumber) {
        return getMultipleChoices().get(indexNumber - 1);
    }

}
