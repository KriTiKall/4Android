package com.example.android_translator.presentation.render;

import com.arellomobile.mvp.MvpView;
import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.List;

public interface MainView extends MvpView {

    void initRecycler(List<TranslationField> data);
}
