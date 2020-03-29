package com.example.android_translator.presentation.presenters;


import io.reactivex.Observable;

public interface TextChangeHandler{
    void onChange(Observable<String> streamOfText);
}
