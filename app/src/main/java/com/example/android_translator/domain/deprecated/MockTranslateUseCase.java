package com.example.android_translator.domain.deprecated;

import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.Collections;

public class MockTranslateUseCase implements TranslateUseCase {

    @Override
    public TranslationField translate(String word) {
        return new TranslationField(123, word, Collections.singletonList(word + ":translate"));
    }
}
