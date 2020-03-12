package com.example.android_translator.domain;

import com.example.android_translator.domain.data_perform.TranslationField;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TranslateService {

    String BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    @POST("key={key}&text={text}&lang={flang}-{slang}&options=1")
    public Observable<TranslationField> getTranslation(@Path("key") String key,
                                             @Path("text") String text,
                                             @Path("flang") String flang,
                                             @Path("slang") String slang);
}
