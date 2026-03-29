package com.soemoe.kanjiflashcard.models;

public class Kanji {
    private String kanji;
    private String onyomi;
    private String kunyomi;
    private String meaning;
    private String kanjiLevel;

    //constructor
    public Kanji(String kanji, String onyomi, String kunyomi, String meaning, String kanjiLevel) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.kanjiLevel = kanjiLevel;
    }

    //getter
    public String getKanjiChar() {
        return kanji;
    }

    public String getOnyomi() {
        return onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getKanjiLevel() {
        return kanjiLevel;
    }
}
