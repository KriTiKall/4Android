package com.example.android_translator.domain.usecase;

import com.example.android_translator.domain.essences.PossibleTranslation;

import retrofit2.Call;


public interface YandexTransletationUseCase {
    Call<PossibleTranslation> allTranslation(String text);
}
