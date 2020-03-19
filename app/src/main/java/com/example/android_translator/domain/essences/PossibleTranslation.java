package com.example.android_translator.domain.essences;

import java.util.List;

public class PossibleTranslation {

    private List<String> translations = null;

    public PossibleTranslation(List<String> translations) {
        this.translations = translations;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}
