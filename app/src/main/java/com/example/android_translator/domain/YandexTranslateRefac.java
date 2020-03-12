package com.example.android_translator.domain;

public class YandexTranslateRefac {

    enum lang {}
    private final String apiKey = "trnsl.1.1.20130918T211717Z.3ab20d41ced64e5d.224265dad05a5d229373fbeff6090f3c95107941";

    public String getApiKey(){
        return apiKey;
    }
}
