package com.example.android_translator.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.List;

import rx.Observable;

public interface AppendView extends MvpView {
    Observable<CharSequence> getTextFromEditText();
    void initRecycler(List<String> data);
}
