package com.soemoe.kanjiflashcard;
import com.soemoe.kanjiflashcard.models.KanjiCard;
import com.soemoe.kanjiflashcard.services.QuizService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<KanjiCard> deck = new ArrayList<>();
        QuizService quizService = new QuizService(1, deck);
        quizService.startQuiz();
    }

}
