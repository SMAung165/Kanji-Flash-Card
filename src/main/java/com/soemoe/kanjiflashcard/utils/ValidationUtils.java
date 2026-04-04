package com.soemoe.kanjiflashcard.utils;

import com.soemoe.kanjiflashcard.models.KanjiCard;

public class ValidationUtils {
    public static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateUserAnswer(String userAnswer, KanjiCard currentCard) {
        return (ValidationUtils.isNumeric(userAnswer))
                && (Integer.parseInt(userAnswer) > 0)
                && (Integer.parseInt(userAnswer) <= currentCard.getMultipleChoices().size());
    }
}
