package com.soemoe.kanjiflashcard.utils;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonLoader {
    private String jsonString;

    //constructors
    public JsonLoader(String filePath) {
        InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        this.jsonString = gson.toJson(inputStreamReader, String.class);
    }

    //getters
    public String getJsonString() {
        return jsonString;
    }
}
