package com.soemoe.kanjiflashcard.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.soemoe.kanjiflashcard.models.Kanji;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class JsonLoader {
    private final Kanji[] kanjiList;

    //constructors
    public JsonLoader(String fileName) {
        Gson gson = new Gson();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalStateException("File not found!");
        }
        try (Reader reader = new InputStreamReader(inputStream)) {
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
