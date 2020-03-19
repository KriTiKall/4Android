package com.example.android_translator.domain.data_perform;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class TranslationField {

    @PrimaryKey
    private int id;
    private String word;
    @SerializedName("text")
    private List<String> translations;

    public TranslationField(int id, String word, List<String> translations) {
        this.id = id;
        this.word = word;
        this.translations = translations;
    }

    public int getId() {
        return id;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
