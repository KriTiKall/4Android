package com.example.android_translator.entety;

import com.example.android_translator.domain.TranslateService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.android_translator.domain.TranslateService.BASE_URL;

class Core {
    private static final Core ourInstance = new Core();

    static Core getInstance() {
        return ourInstance;
    }

    private Retrofit retrofit;
    private TranslateService translateService;

    private Core() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient.Builder().build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        translateService = retrofit.create(TranslateService.class);
    }

    public TranslateService getTranslateService(){
        return translateService;
    }
}
