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
        return onyomi == null || onyomi.isEmpty() ? "" : onyomi.get(0);
    }

    public String getKunyomi() {
        return kunyomi == null || kunyomi.isEmpty() ? "" : kunyomi.get(0);
    }

    public String getMeaning() {
        return meaning == null || meaning.isEmpty() ? "" : meaning.get(0);
    }

    public String getKanjiLevel() {
        return jlptLevel;
    }
}
