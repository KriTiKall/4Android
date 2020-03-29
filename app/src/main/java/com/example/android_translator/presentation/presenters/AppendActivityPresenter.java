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

//        getViewState().setTextHandler((charSequence) -> {
//            charSequence.observeOn(Schedulers.io())
//                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((data) -> {
//                    data.enqueue(new Callback<PossibleTranslation>() {
//                        @Override
//                        public void onResponse(Call<PossibleTranslation> call, Response<PossibleTranslation> response) {
//                            if(!response.isSuccessful()){
//                                getViewState().initRecycler(Arrays.asList("Code: " + response.code()));
//                                Log.e("AppendPresenter","Code: " + response.code());
//                                return;
//                            }
//                            getViewState().initRecycler(response.body().getTranslations());
//                        }
//
//                        @Override
//                        public void onFailure(Call<PossibleTranslation> call, Throwable t) {
//                            Log.e("AppendPresenter",t.getMessage());
//                            getViewState().initRecycler(Arrays.asList(t.getMessage()));
//                        }
//                    });
//                }, (errData) -> Log.e("IN obs", "/////////////////////" + errData.getMessage()));
//        });
//        getViewState().setTextHandler((charSequence) -> {
//            charSequence.map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((data) -> {
//                    try{
//                        getViewState().initRecycler(data.execute().body().getTranslations());
//                    }catch(IOException e){
//                        Log.e("IN observable", "" + e.getMessage());
//                    }
//                });
//        });
    }

    @SuppressLint("CheckResult")
    void onEnter(Observable<String> streamOfText){
                streamOfText.observeOn(Schedulers.io())
                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((possibleTranslation) ->  getViewState().initRecycler(possibleTranslation.getTranslations())
                        , (errData) -> Log.e("AppendPresenter", "___________________" + errData.getMessage()));
//        streamOfText.observeOn(Schedulers.io())
//                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((data) -> {
//                    data.enqueue(new Callback<PossibleTranslation>() {
//                        @Override
//                        public void onResponse(Call<PossibleTranslation> call, Response<PossibleTranslation> response) {
//                            if(!response.isSuccessful()){
//                                getViewState().initRecycler(Collections.singletonList("Code: " + response.code()));
//                                Log.e("AppendPresenter","Code: " + response.code());
//                                return;
//                            }
//                            getViewState().initRecycler(response.body().getTranslations());
//                        }
//
//                        @Override
//                        public void onFailure(Call<PossibleTranslation> call, Throwable t) {
//                            Log.e("AppendPresenter",t.getMessage());
//                            getViewState().initRecycler(Arrays.asList(t.getMessage()));
//                        }
//                    });
//                }, (errData) -> Log.e("IN obs", "/////////////////////" + errData.getMessage()));
    }

}
