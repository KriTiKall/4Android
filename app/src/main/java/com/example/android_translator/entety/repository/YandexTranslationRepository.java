package com.example.android_translator.entety.repository;

import com.example.android_translator.entety.Core;
import com.example.android_translator.entety.YandexTranslateService;
import com.example.android_translator.entety.essences.YandexTranslationJson;
import io.reactivex.Single;

public class YandexTranslationRepository implements Repository<YandexTranslationJson> {

    private YandexTranslateService yandexTranslateService;

    public YandexTranslationRepository() {
        this.yandexTranslateService = Core.getInstance().getYandexTranslateService();
    }

    @Override
    public Single<YandexTranslationJson> all(String text) {
        return yandexTranslateService.getTranslation(text);
    }
}
