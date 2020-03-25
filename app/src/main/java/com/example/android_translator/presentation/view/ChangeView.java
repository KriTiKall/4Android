package com.example.android_translator.presentation.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface ChangeView extends MvpView {
    void initRecycler(List<String> data);
}
