package com.soemoe.kanjiflashcard.services;

import com.soemoe.kanjiflashcard.models.Kanji;
import com.soemoe.kanjiflashcard.utils.JsonLoader;

import java.util.ArrayList;
import java.util.Arrays;

public class KanjiDatabase {
    private final ArrayList<Kanji> kanjis;

    //constructors
    public KanjiDatabase(String level) {
        kanjis = getKanjiByLevel(level);
    }

    //getters
    public ArrayList<Kanji> getKanjis() {
        return kanjis;
    }

    //methods
    private ArrayList<Kanji> getKanjiByLevel(String level) {
        JsonLoader loadKanjiList = new JsonLoader(String.format("src/main/resources/kanji_%s.json", level));
        return new ArrayList<>(Arrays.asList(loadKanjiList.getKanjiList()));
    }
}
