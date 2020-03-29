package com.example.android_translator.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.presentation.presenters.TextChangeHandler;

import java.util.List;

import rx.Observable;

public interface AppendView extends MvpView {
    void setTextHandler(TextChangeHandler textHandler);
    void initRecycler(List<String> data);
}
