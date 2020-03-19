package com.example.android_translator.entety;

import com.example.android_translator.entety.essences.YandexTranslationJson;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface YandexTranslateService {
    String BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/";
    String API_KEY = "trnsl.1.1.20130918T211717Z.3ab20d41ced64e5d.224265dad05a5d229373fbeff6090f3c95107941";
    String LANG_EN_RU = "en-ru";

    @POST("translate?key=" + API_KEY + "&lang=" + LANG_EN_RU + "&options=0")
    public Single<YandexTranslationJson> getTranslation(@Query("text") String text);
}