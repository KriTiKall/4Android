package com.example.android_translator.domain.data_perform;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class TranslationField {

    @PrimaryKey
    private int id;
    private String word;
    @SerializedName("text")
    private String translation;

    public TranslationField(int id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
