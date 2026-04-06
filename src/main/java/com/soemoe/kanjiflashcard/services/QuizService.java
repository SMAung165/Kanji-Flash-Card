package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;


public class QuizService implements Reviewable {

    private KanjiCard currentCard;
    private final ArrayList<KanjiCard> incorrectCards = new ArrayList<>();
    private ArrayList<KanjiCard> quizDeck;
    private final KanjiDatabase kanjiDatabase;

    private final int kanjiCount;
    private int score;

    //constructors
    public QuizService(String jlptLevel, int kanjiCount) {
        this.kanjiCount = kanjiCount;
        this.score = 0;
        this.kanjiDatabase = new KanjiDatabase(jlptLevel);
        deckPreparation();
    }

    //getters
    @Override
    public ArrayList<KanjiCard> getQuizDeck() {
        return quizDeck;
    }

    @Override
    public ArrayList<KanjiCard> getIncorrectCards() {
        return incorrectCards;
    }

    public ArrayList<String> generateChoicesForCard(KanjiCard card) {
        this.currentCard = card;
        return generateRandomChoices();
    }

    @Override
    public int getScore() {
        return score;
    }

    //methods
    public boolean processUserAnswer(String userAnswer) {
        currentCard.setUserChoice(currentCard.getMultipleChoices().get(Integer.parseInt(userAnswer) - 1));
        if (currentCard.getCorrectReading().equals(currentCard.getUserChoice())) {
            score++;
            return true;
        } else {
            incorrectCards.add(currentCard);
            return false;
        }
    }

    //internal methods
    private void deckPreparation() {
        Kanji randomKanji;
        KanjiCard randomKanjiCard;
        ArrayList<KanjiCard> deck = new ArrayList<>();
        int numberOfKanjiByUserInput = Math.min(kanjiCount, kanjiDatabase.getKanjis().size());

        int i = 0;
        while (i != numberOfKanjiByUserInput) {
            randomKanji = getRandomKanji();
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

    private ArrayList<String> generateRandomChoices() {
        ArrayList<String> randomReadingChoices = new ArrayList<>();
        Kanji randomKanji;
        String randomReading;
        int i = 0;
        while (i != 3) {
            randomKanji = getRandomKanji();
            randomReading = randomKanji.getKunyomi() + ", " + randomKanji.getOnyomi();
            if (!randomReadingChoices.contains(randomReading) && !randomReading.equals(currentCard.getCorrectReading())) {
                randomReadingChoices.add(randomReading);
                i++;
            }
        }
        randomReadingChoices.add(currentCard.getCorrectReading());
        return randomReadingChoices;
    }

    //utility methods
    private Kanji getRandomKanji() {
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
