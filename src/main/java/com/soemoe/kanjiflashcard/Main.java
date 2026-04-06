package com.soemoe.kanjiflashcard;

import com.soemoe.kanjiflashcard.models.KanjiCard;
import com.soemoe.kanjiflashcard.services.QuizService;
import com.soemoe.kanjiflashcard.services.QuizUI;
import com.soemoe.kanjiflashcard.utils.ValidationUtils;

public class Main {
    public static void main(String[] args) {
        QuizUI quizUI = new QuizUI();
        String level  = quizUI.getLevel();
        int kanjiCount = quizUI.getKanjiCount();
        QuizService quizService = new QuizService(level, kanjiCount);
        startQuiz(quizUI, quizService);
    }


    //core methods
    private static void startQuiz(QuizUI quizUI, QuizService quizService) {
        int cardNumber = 1;
        for (KanjiCard card : quizService.getQuizDeck()) {
            card.setCardNumber(cardNumber++);
            quizUI.showCard(card);
            card.setMultipleChoices(quizService.generateChoicesForCard(card));
            quizUI.showMultipleChoices(card);
            while (true) {
                String userAnswer = quizUI.getUserAnswer();
                if (ValidationUtils.validateUserAnswer(userAnswer, card)) {
                    quizUI.responseUserAnswer(quizService.processUserAnswer(userAnswer));
                    break;
                } else {
                    quizUI.invalidUserInput();
                }
            }
        }
        quizUI.showResults(quizService.getScore(), quizService.getIncorrectCards().size());
        if (!quizService.getIncorrectCards().isEmpty()) quizUI.showMistakes(quizService.getIncorrectCards());
    }

}
