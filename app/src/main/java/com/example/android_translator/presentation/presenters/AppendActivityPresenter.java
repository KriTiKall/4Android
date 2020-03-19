package com.example.android_translator.presentation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.data_perform.TranslateFieldHandMockItems;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.domain.deprecated.MockTranslateUseCase;
import com.example.android_translator.domain.deprecated.TranslateUseCase;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.AppendView;

import java.util.List;

@InjectViewState
public class AppendActivityPresenter extends MvpPresenter<AppendView>  {


    private final YandexTranslationUseCaseImp yandexTranslationUseCaseImp;

    public AppendActivityPresenter() {
        this.yandexTranslationUseCaseImp = new YandexTranslationUseCaseImp(new YandexTranslationRepository());
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        List<String> data = yandexTranslationUseCaseImp.allTranslation();
        getViewState().initRecycler(data);
    }
}
