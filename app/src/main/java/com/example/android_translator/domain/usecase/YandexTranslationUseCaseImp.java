package com.example.android_translator.domain.usecase;

import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.android_translator.domain.mappers.Mapper;
import com.example.android_translator.domain.mappers.YandexTranslationMapper;
import com.example.android_translator.entety.essences.YandexTranslationJson;
import com.example.android_translator.entety.repository.Repository;
import com.example.android_translator.entety.repository.YandexTranslationRepository;

import java.io.IOException;

import retrofit2.Call;
import rx.Single;

public class YandexTranslationUseCaseImp implements YandexTransletationUseCase {

    private final Mapper mapper;
    private final Repository repository;

    public YandexTranslationUseCaseImp(YandexTranslationRepository repository) {
        this.repository = repository;
        mapper = new YandexTranslationMapper();
    }

    @Override
    public PossibleTranslation allTranslation(String text) {
        try {
            return (PossibleTranslation) mapper.map((YandexTranslationJson)repository.all(text).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        //return repository.all(text).map((e) ->  mapper.map((YandexTranslationJson) e));
    }
}
