package com.example.android_translator.domain;

import com.example.android_translator.domain.data_perform.TranslationField;

public interface TranslateUseCase {

    TranslationField translate(String word); // enum Lang
}
