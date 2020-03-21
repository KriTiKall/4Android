package com.example.android_translator.presentation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.ChangeView;

@InjectViewState
public class ChangeActivityPresenter extends MvpPresenter<ChangeView> {

    private final YandexTranslationUseCaseImp yandexTranslationUseCaseImp;

    public ChangeActivityPresenter() {
        this.yandexTranslationUseCaseImp = new YandexTranslationUseCaseImp(new YandexTranslationRepository());
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }
}
