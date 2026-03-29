package com.soemoe.kanjiflashcard.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.soemoe.kanjiflashcard.models.Kanji;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class JsonLoader {
    private final Kanji[] kanjiList;

    //constructors
    public JsonLoader(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            kanjiList = gson.fromJson(reader, Kanji[].class);
        } catch (IOException | JsonSyntaxException e) {
            throw new RuntimeException("Failed to load JSON", e);
        }
    }

    //getters
    public Kanji[] getKanjiList() {
        return kanjiList;
    }
}
