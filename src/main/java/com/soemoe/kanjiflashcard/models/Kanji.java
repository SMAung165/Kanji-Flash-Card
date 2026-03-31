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
        return onyomi == null || onyomi.isEmpty() ? "On: {none}" : String.format("On: {%s}", String.join(", ", onyomi));
    }

    public String getKunyomi() {
        return kunyomi == null || kunyomi.isEmpty() ? "Kun: {none}" : String.format("Kun: {%s}", String.join(", ", kunyomi));
    }

    public String getMeaning() {
        return meaning == null || meaning.isEmpty() ? "" : String.join(", ", meaning);
    }

    public String getKanjiLevel() {
        return jlptLevel;
    }

}
