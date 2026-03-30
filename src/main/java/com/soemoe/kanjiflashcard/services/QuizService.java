package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.models.KanjiCard;

import java.util.ArrayList;
import java.util.Scanner;


public class QuizService implements Reviewable {

    private KanjiCard currentCard;
    private ArrayList<KanjiCard> incorrectCards;
    private ArrayList<KanjiCard> quizDeck;
    private final KanjiDatabase kanjiDatabase;
    private final Scanner userChoice;

    private final int kanjiCount;
    private int score;
    private int currentCardIndex = 0;

    //constructors
    public QuizService(String jlptLevel, int KanjiCount) {
        this.kanjiCount = KanjiCount;
        this.score = 0;
        KanjiDatabase kanjiDatabase = new KanjiDatabase(jlptLevel);
        this.kanjiDatabase = kanjiDatabase;
        deckPreparation(kanjiDatabase);
        userChoice = new Scanner(System.in);
    }

    //methods
    @Override
    public void startQuiz() {
        for (KanjiCard card : quizDeck) {
            currentCardIndex++;
            currentCard = card;
            card.showCard();
            System.out.println("Card Number: " + currentCardIndex);
            card.setMultipleChoices(generateRandomChoices(kanjiDatabase));
            card.showMultipleChoices();
            verifyAnswer();
        }
        showResults();
    }

    @Override
    public void verifyAnswer() {
        System.out.print("Your answer: ");
        while (true) {
            String userAnswer = userChoice.nextLine();
            if (isNumeric(userAnswer) && Integer.parseInt(userAnswer) <= currentCard.getMultipleChoices().size()) {
                if (currentCard.getCorrectReading().equals(currentCard.getUserChoice(Integer.parseInt(userAnswer)))) {
                    score++;
                    System.out.println("Your answer is correct!");
                } else {
                    System.out.println("Your answer is incorrect!");
                }
                return;
            } else {
                System.out.println("Please enter a valid answer.");
                System.out.print("> ");
            }
        }

    }

    @Override
    public void showResults() {
        System.out.println("Correct: " + score);
        System.out.println("Incorrect: " + (kanjiCount - score));
        if(score > kanjiCount/2) {
            System.out.println("偉い、よくやった！");
        }
        else{
            System.out.println("ちゃんと勉強しろ!!");
        }
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

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
