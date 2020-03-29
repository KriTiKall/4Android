package com.example.android_translator.presentation.presenters;

import rx.Observable;

public interface TextChangeHandler{
    void onChange(Observable<CharSequence> StreamOfText);
}
