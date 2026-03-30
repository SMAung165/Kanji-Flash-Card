package com.soemoe.kanjiflashcard.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Kanji {
    private final String kanji;
    @SerializedName("on_readings")
    private List<String> onyomi;
    @SerializedName("kun_readings")
    private List<String> kunyomi;
    @SerializedName("meanings")
    private List<String> meaning;
    @SerializedName("jlpt")
    private String jlptLevel;

    //constructor
    public Kanji(String kanji, List<String> onyomi, List<String> kunyomi, List<String> meaning, String jlptLevel) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.jlptLevel = jlptLevel;
    }

    //getter
    public String getKanjiChar() {
        return kanji;
    }

    public String getOnyomi() {
        String result;
        if (onyomi == null || onyomi.isEmpty()) {
            result = "none";
        } else {
            StringBuilder onyomiReadingList = new StringBuilder();
            for (String onyomi : onyomi) {
                onyomiReadingList.append(onyomi).append(", ");
            }
            result = removeExtraDelimiter(onyomiReadingList.toString(), ",");
        }
        return String.format("On: {%s}", result);
    }

    public String getKunyomi() {
        String result;
        if (kunyomi == null || kunyomi.isEmpty()) {
            result = "none";
        } else {
            StringBuilder kunyomiReadingList = new StringBuilder();
            for (String kunyomi : onyomi) {
                kunyomiReadingList.append(kunyomi).append(", ");
            }
            result = removeExtraDelimiter(kunyomiReadingList.toString(), ",");
        }
        return String.format("Kun: {%s}", result);
    }

    public String getMeaning() {
        return meaning == null || meaning.isEmpty() ? null : meaning.get(0);
    }

    public String getKanjiLevel() {
        return jlptLevel;
    }

    //utility methods
    private String removeExtraDelimiter(String inputString, String delimiter) {
        StringBuilder result = new StringBuilder(inputString.trim());
        if (result.substring(result.length() - 1).equals(delimiter)) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
