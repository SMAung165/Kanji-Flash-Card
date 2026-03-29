package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.utils.JsonLoader;

import java.util.ArrayList;
import java.util.Arrays;

public class KanjiDatabase {
    private ArrayList<Kanji> kanjis = new ArrayList<>();
    private JsonLoader jsonLoader = new JsonLoader("kanji.json");

    //constructors
    public KanjiDatabase() {
        kanjis.addAll(Arrays.asList());
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
