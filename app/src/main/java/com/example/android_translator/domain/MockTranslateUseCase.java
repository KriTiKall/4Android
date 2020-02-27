package com.example.android_translator.domain;

import com.example.android_translator.data_perform.TranslationField;

public class MockTranslateUseCase implements TranslateUseCase {

    @Override
    public TranslationField translate(String word) {
        return new TranslationField(123, word, word + ":translate");
    }
}
