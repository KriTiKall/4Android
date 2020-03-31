package com.example.android_translator.entety.essences;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
//{"code":200,"lang":"en-ru","text":["наговор"]}
public class YandexTranslationJson {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("text")
    @Expose
    private List<String> posTranslate;

    public YandexTranslationJson(int code, String lang, List<String> posTranslate) {
        this.code = code;
        this.lang = lang;
        this.posTranslate = posTranslate;
    }

    public List<String> getPosTranslate() {
        return posTranslate;
    }

    public void setPosTranslate(List<String> posTranslate) {
        this.posTranslate = posTranslate;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}