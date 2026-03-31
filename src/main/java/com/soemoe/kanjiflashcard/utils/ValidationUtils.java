package com.soemoe.kanjiflashcard.utils;

public class ValidationUtils {
    public static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
