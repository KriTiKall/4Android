package com.example.android_translator.entety;

import com.example.android_translator.entety.essences.YandexTranslationJson;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface YandexTranslateService {

    String API_KEY = "trnsl.1.1.20200329T172100Z.5ab51266982ef9bf.baa6b90d958cfb3c70d720e1a237a3768898b33c";
    String LANG_EN_RU = "en-ru";

    @POST("translate?key=" + API_KEY + "&lang=" + LANG_EN_RU + "&options=0")
    public Call<YandexTranslationJson> getTranslation(@Query("text") String text);
}