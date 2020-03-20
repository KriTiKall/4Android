package com.example.android_translator.presentation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.AppendView;

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
        /*getViewState().getTextFromEditText()
                .map((text) -> yandexTranslationUseCaseImp.allTranslation(text.toString()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((data) -> );*/
                //.subscribe((data) -> getViewState().initRecycler(data.blockingGet().getTranslations()));
    }
}
