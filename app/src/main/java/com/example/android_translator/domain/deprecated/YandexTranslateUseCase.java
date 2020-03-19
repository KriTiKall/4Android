package com.example.android_translator.domain.deprecated;

import com.example.android_translator.domain.data_perform.TranslationField;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * TODO to change the class based on the article:
 * 1. https://habr.com/ru/post/428736/
 * 2. https://habr.com/ru/post/305478/
 * intrasting link -> https://www.journaldev.com/20433/android-rxjava-retrofit
 */
public class YandexTranslateUseCase implements TranslateUseCase {

    private YandexTranslateObject object;
    private OkHttpClient client;

    public YandexTranslateUseCase() {
        client = new OkHttpClient();
        object = new YandexTranslateObject();
    }

    @Override
    public TranslationField translate(String word) {
        JSONObject jsonObject = null;
        String translation = null;
        try {
            jsonObject = new JSONObject(getJSON(word));
            translation = jsonObject.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return new TranslationField(1, translation, word);
    }

    private String getJSON(String word) { //TODO append enum lang
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", object.getApiKey())
                .addFormDataPart("text", word)
                .addFormDataPart("lang", "") //TODO insert from arguments
                .addFormDataPart("options", "1")
                .build();

        Request request = new Request.Builder()
                .url("https://translate.yandex.net/api/v1.5/tr.json/translate")
                .post(requestBody)
                .build();

        return request.body().toString();
    }
/*
    void mm(String word, String fromLang, String toLang){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        UUID.randomUUID().toString().hashCode();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TranslateService service = retrofit.create(TranslateService.class);
        Observable<TranslationField> translationFieldObservable = service.getTranslation(object.getApiKey(), word, fromLang, toLang);

    }*/
}
