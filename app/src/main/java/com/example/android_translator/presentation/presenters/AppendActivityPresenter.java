package com.example.android_translator.presentation.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.AppendView;

import java.io.IOException;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class AppendActivityPresenter extends MvpPresenter<AppendView> {

    private final YandexTranslationUseCaseImp yandexTranslationUseCaseImp;

    public AppendActivityPresenter() {
        this.yandexTranslationUseCaseImp = new YandexTranslationUseCaseImp(new YandexTranslationRepository());
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().setTextHandler((charSequence) -> {
            charSequence.observeOn(Schedulers.io())
                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((data) -> {
                    data.enqueue(new Callback<PossibleTranslation>() {
                        @Override
                        public void onResponse(Call<PossibleTranslation> call, Response<PossibleTranslation> response) {
                            if(!response.isSuccessful()){
                                getViewState().initRecycler(Arrays.asList("Code: " + response.code()));
                                Log.e("AppendPresenter","Code: " + response.code());
                                return;
                            }
                            getViewState().initRecycler(response.body().getTranslations());
                        }

                        @Override
                        public void onFailure(Call<PossibleTranslation> call, Throwable t) {
                            Log.e("AppendPresenter",t.getMessage());
                            getViewState().initRecycler(Arrays.asList(t.getMessage()));
                        }
                    });
                }, (errData) -> Log.e("IN obs", "/////////////////////" + errData.getMessage()));
        });
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
}
