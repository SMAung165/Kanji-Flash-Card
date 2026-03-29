package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;


public class QuizService implements Reviewable {

    private KanjiCard currentCard;
    private ArrayList<KanjiCard> incorrectCards;
    private ArrayList<KanjiCard> quizDeck;

    private int kanjiCount;
    private int score;
    private int currentCardIndex = 0;

    private String jlptLevel;

    //constructors
    public QuizService(String jlptLevel, int KanjiCount) {
        this.kanjiCount = KanjiCount;
        this.jlptLevel = jlptLevel;
        this.score = 0;
        deckPreparation();
    }

    //methods
    @Override
    public void startQuiz() {
        for(KanjiCard card : quizDeck) {
            card.showCard();
        }
    }

    @Override
    public void verifyAnswer() {
    }

    @Override
    public void showResults() {

    }

    @Override
    public void showMistakes() {

    }

    //internal methods
    private void deckPreparation() {
        KanjiDatabase kanjiDatabase = new KanjiDatabase();
        Kanji randomKanji;
        KanjiCard randomKanjiCard;
        ArrayList<KanjiCard> deck = new ArrayList<>();
        int numberOfKanjiByUserInput = Math.min(kanjiCount, kanjiDatabase.getKanjiByLevel(jlptLevel).size());

        int i = 0;
        while (i != numberOfKanjiByUserInput) {
            randomKanji = getRandomKanjiByLevel(kanjiDatabase);
            randomKanjiCard = new KanjiCard(randomKanji.getKanjiChar(), randomKanji.getMeaning(), randomKanji.getKunyomi());

            if (!isKanjiCardDuplicated(randomKanjiCard, deck)) {
                deck.add(randomKanjiCard);
                i++;
            }
        }
        quizDeck = deck;
    }

    private Kanji getRandomKanjiByLevel(KanjiDatabase kanjiDatabase) {
        int randomIndexNumber = (int) (Math.random() * (kanjiDatabase.getKanjiByLevel(jlptLevel).size()));
        return kanjiDatabase.getKanjiByLevel(jlptLevel).get(randomIndexNumber);
    }

    private boolean isKanjiCardDuplicated(KanjiCard checkingKanjiCard, ArrayList<KanjiCard> kanjiList) {
        for (KanjiCard targetKanjiCard : kanjiList) {
            if (checkingKanjiCard.getWord().equals(targetKanjiCard.getWord())) {
                return true;
            }
        }
        return false;
    }
}
