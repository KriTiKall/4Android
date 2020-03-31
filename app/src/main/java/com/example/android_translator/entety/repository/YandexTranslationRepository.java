package com.example.android_translator.entety.repository;

import com.example.android_translator.entety.Core;
import com.example.android_translator.entety.YandexTranslateService;
import com.example.android_translator.entety.essences.YandexTranslationJson;

import retrofit2.Call;

public class YandexTranslationRepository implements Repository<YandexTranslationJson> {

    private YandexTranslateService yandexTranslateService;

    public YandexTranslationRepository() {
        this.yandexTranslateService = Core.getInstance().getYandexTranslateService();
    }

    @Override
    public Call<YandexTranslationJson> all(String text) {
        return yandexTranslateService.getTranslation(text);
    }
}