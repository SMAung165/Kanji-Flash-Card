package com.soemoe.kanjiflashcard.services;
import com.soemoe.kanjiflashcard.contracts.Reviewable;
import com.soemoe.kanjiflashcard.models.Kanji;
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
        KanjiCard kanjiCard = new KanjiCard();
        KanjiDatabase kanjiDatabase = new KanjiDatabase();
        Kanji randomKanji = getRandomKanji(kanjiDatabase);
        kanjiCard.setupKanjiCard(randomKanji.getKanjiChar(), randomKanji.getMeaning(), randomKanji.getKunyomi());
        kanjiCard.showCard();
//        kanjiCard.showMultipleChoices(makeRandomKanjiList(kanjiDatabase));
    }

    @Override
    public void verifyAnswer() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What's the answer?: ");
        userInput.nextLine();
    }

    @Override
    public void showResults() {

    }

    @Override
    public void showMistakes() {

    }

    public static Kanji getRandomKanji(KanjiDatabase kanjiDatabase) {
        int randomIndexNumber = (int) (Math.random() * (kanjiDatabase.getKanjis().size()));
        return kanjiDatabase.getKanjis().get(randomIndexNumber);
    }

    public ArrayList<String> makeRandomKanjiList(KanjiDatabase kanjiDatabase) {
        ArrayList<String> choices = new ArrayList<>();
        int i = 0;
        String randomKunReading;
        while (i != 3) {
            randomKunReading = getRandomKanji(kanjiDatabase).getKunyomi();
            if (!choices.contains(randomKunReading)) {
                choices.add(randomKunReading);
                i++;
            }
        }
        return choices;
    }


}
