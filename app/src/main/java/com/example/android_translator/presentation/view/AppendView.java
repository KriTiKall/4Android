package com.example.android_translator.presentation.view;

import com.arellomobile.mvp.MvpView;
import io.reactivex.Observable;

public interface AppendView extends MvpView {
    Observable<String> getTextFromEditText();
}
