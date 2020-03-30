package com.example.android_translator.entety;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;
//http://46.146.211.31:8081/
public class Core {

    private static final String BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/";

    private static Core core;

    private Retrofit apiRetrofit;

    private YandexTranslateService yandexTranslateService;

    private Core(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .build();

        apiRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        yandexTranslateService = apiRetrofit.create(YandexTranslateService.class);
    }

    public YandexTranslateService getYandexTranslateService() {
        return yandexTranslateService;
    }

    public static Core getInstance() {
        if(core == null) {
            core = new Core();
        }
        return core;
    }
}
