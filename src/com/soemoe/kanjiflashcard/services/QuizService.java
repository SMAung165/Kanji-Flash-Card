package com.soemoe.kanjiflashcard.services;
import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService implements Reviewable {

    private KanjiCard currentCard;
    private int kanjiCount;
    private ArrayList<KanjiCard> incorrectCards;
    private ArrayList<KanjiCard> quizDeck;
    private int score;
    private int currentCardIndex = 0;

    //constructor
    public QuizService(int KanjiCount, ArrayList<KanjiCard> quizDeck) {
        this.kanjiCount = KanjiCount;
        this.quizDeck = quizDeck;
        this.score = 0;
        this.incorrectCards = new ArrayList<>();
    }

    //methods
    @Override
    public void startQuiz() {
    }

    @Override
    public void verifyAnswer() {
        System.out.print("What's the answer?: ");
    }

    @Override
    public void showResults() {

    }

    @Override
    public void showMistakes() {

    }

}
