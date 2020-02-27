package com.example.android_translator.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import com.example.android_translator.data_perform.TranslationField;
import com.example.android_translator.domain.TranslateUseCase;
import com.example.android_translator.presentation.render.MainView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {
    private final TranslateUseCase translareUseCase;

    public MainActivityPresenter(TranslateUseCase translareUseCase){

    }

    public void onTranslate(String word){
        TranslationField translate = translareUseCase.translate(word);
        get
    }
}
