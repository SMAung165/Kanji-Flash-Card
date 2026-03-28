package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.models.Kanji;

import java.util.ArrayList;
import java.util.Arrays;

public class KanjiDatabase {
    private ArrayList<Kanji> kanjis = new ArrayList<>();

    //constructors
    public KanjiDatabase() {
        kanjis.addAll(Arrays.asList(
                new Kanji("対", "セイ", "まつりごと", "politics, government"),
                new Kanji("合", "ゴウ", "あ(う)", "fit, suit, join"),
                new Kanji("市", "シ", "いち", "market, city, town"),
                new Kanji("戦", "セン", "たたか(う)", "war, battle, match"),
                new Kanji("回", "カイ","まわ(す)","imes, round, revolve, counter")
        ));
    }

    //getters

    public ArrayList<Kanji> getKanjis() {
        return kanjis;
    }


    //methods
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
