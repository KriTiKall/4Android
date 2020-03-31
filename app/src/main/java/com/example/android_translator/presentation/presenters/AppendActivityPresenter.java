package com.example.android_translator.presentation.presenters;

import android.annotation.SuppressLint;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.AppendView;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class AppendActivityPresenter extends MvpPresenter<AppendView> {

    private final YandexTranslationUseCaseImp yandexTranslationUseCaseImp;

    private TextChangeHandler textHandler = this::onEnter;

    public AppendActivityPresenter() {
        this.yandexTranslationUseCaseImp = new YandexTranslationUseCaseImp(new YandexTranslationRepository());
    }

    public TextChangeHandler getTextHandler() {
        return textHandler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    void onEnter(Observable<String> streamOfText){
                streamOfText.observeOn(Schedulers.io())
                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((possibleTranslation) ->  getViewState().initRecycler(possibleTranslation.getTranslations())
                        , (errData) -> Log.e("AppendPresenter", "___________________" + errData.getMessage()));
    }

}
