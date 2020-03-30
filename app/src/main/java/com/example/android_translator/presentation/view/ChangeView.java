package com.example.android_translator.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.example.android_translator.presentation.presenters.TextChangeHandler;

import java.util.List;

public interface ChangeView extends MvpView {
    void setTextHandler(TextChangeHandler textHandler);
    void initRecycler(List<String> data);
}
