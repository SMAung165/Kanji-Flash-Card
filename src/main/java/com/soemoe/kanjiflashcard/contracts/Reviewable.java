package com.soemoe.kanjiflashcard.contracts;


import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;

public interface Reviewable {
    boolean processUserAnswer(String userAnswer);
    ArrayList<KanjiCard> getQuizDeck();
    ArrayList<KanjiCard> getIncorrectCards();
    int getScore();
}
