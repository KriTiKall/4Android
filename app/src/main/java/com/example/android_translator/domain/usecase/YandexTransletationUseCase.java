package com.example.android_translator.domain.usecase;

import com.example.android_translator.domain.essences.PossibleTranslation;
import rx.Single;


public interface YandexTransletationUseCase {
    Single<PossibleTranslation> allTranslation(String text);
}
