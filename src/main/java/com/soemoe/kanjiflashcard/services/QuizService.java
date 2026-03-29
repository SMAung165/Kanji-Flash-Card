package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;


public class QuizService implements Reviewable {

    private KanjiCard currentCard;
    private ArrayList<KanjiCard> incorrectCards;
    private ArrayList<KanjiCard> quizDeck;
    private final KanjiDatabase kanjiDatabase;

    private final int kanjiCount;
    private int score;
    private int currentCardIndex = 0;

    private final String jlptLevel;

    //constructors
    public QuizService(String jlptLevel, int KanjiCount) {
        this.kanjiCount = KanjiCount;
        this.jlptLevel = jlptLevel;
        this.score = 0;
        KanjiDatabase kanjiDatabase = new KanjiDatabase(jlptLevel);
        this.kanjiDatabase = kanjiDatabase;
        deckPreparation(kanjiDatabase);
    }

    //methods
    @Override
    public void startQuiz() {
        for (KanjiCard card : quizDeck) {
            currentCard = card;
            card.showCard();
            card.showMultipleChoices(generateRandomChoices(kanjiDatabase));
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
    private void deckPreparation(KanjiDatabase kanjiDatabase) {

        Kanji randomKanji;
        KanjiCard randomKanjiCard;
        ArrayList<KanjiCard> deck = new ArrayList<>();
        int numberOfKanjiByUserInput = Math.min(kanjiCount, kanjiDatabase.getKanjis().size());

        int i = 0;
        while (i != numberOfKanjiByUserInput) {
            randomKanji = getRandomKanji(kanjiDatabase);
            randomKanjiCard = new KanjiCard(
                    randomKanji.getKanjiChar(),
                    randomKanji.getMeaning(),
                    randomKanji.getKunyomi() + ", " + randomKanji.getOnyomi());

            if (!isKanjiCardDuplicated(randomKanjiCard, deck)) {
                deck.add(randomKanjiCard);
                i++;
            }
        }
        quizDeck = deck;
    }

    private ArrayList<String> generateRandomChoices(KanjiDatabase kanjiDatabase) {
        ArrayList<String> randomReadingChoices = new ArrayList<>();
        String randomReading;
        int i = 0;
        while (i != 3) {
            randomReading = getRandomKanji(kanjiDatabase).getKunyomi() + ", " + getRandomKanji(kanjiDatabase).getOnyomi();
            if (!randomReadingChoices.contains(randomReading)) {
                randomReadingChoices.add(randomReading);
                i++;
            }
        }
        randomReadingChoices.add(currentCard.getCorrectReading());
        return randomReadingChoices;
    }

    //utility methods
    private Kanji getRandomKanji(KanjiDatabase kanjiDatabase) {
        int randomIndexNumber = (int) (Math.random() * (kanjiDatabase.getKanjis().size()));
        return kanjiDatabase.getKanjis().get(randomIndexNumber);
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
