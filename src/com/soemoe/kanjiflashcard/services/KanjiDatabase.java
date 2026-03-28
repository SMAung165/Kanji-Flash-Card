package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.models.Kanji;

import java.util.ArrayList;
import java.util.Arrays;

public class KanjiDatabase {
    private ArrayList<Kanji> kanjis = new ArrayList<>();

    //constructors
    public KanjiDatabase() {
        kanjis.addAll(Arrays.asList(
                new Kanji("対", "セイ", "まつりごと", "politics, government", "N3"),
                new Kanji("合", "ゴウ", "あ(う)", "fit, suit, join", "N3"),
                new Kanji("市", "シ", "いち", "market, city, town", "N3"),
                new Kanji("戦", "セン", "たたか(う)", "war, battle, match", "N3"),
                new Kanji("回", "カイ", "まわ(す)", "times, round, revolve, counter", "N3"),
                new Kanji("日", "ニチ, ジツ", "ひ, -び, -か", "day, sun, Japan, counter for days", "N5"),
                new Kanji("人", "ジン、 ニン", "ひと", "person", "N5")
        ));
    }

    //getters

    //methods
    public ArrayList<Kanji> getKanjiByLevel(String level) {
        ArrayList<Kanji> kanjiByLevel = new ArrayList<>();
        for (Kanji kanji : kanjis) {
            if (kanji.getKanjiLevel().equals(level)) {
                kanjiByLevel.add(kanji);
            }
        }
        return kanjiByLevel;
    }

    public String getKanjiChar(int index) {
        return kanjis.get(index).getKanjiChar();
    }

    public String getOnyomi(int index) {
        return kanjis.get(index).getOnyomi();
    }

    public String getKunyomi(int index) {
        return kanjis.get(index).getKunyomi();
    }

    public String getMeaning(int index) {
        return kanjis.get(index).getMeaning();
    }

}
