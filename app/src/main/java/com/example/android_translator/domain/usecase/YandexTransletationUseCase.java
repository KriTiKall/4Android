package com.example.android_translator.domain.usecase;

import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.myapplication.domain.essences.PossibleTranslation;
import io.reactivex.Single;

public interface YandexTransletationUseCase {
    public Single<PossibleTranslation> allTranslation(String text);
}
