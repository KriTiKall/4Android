package com.example.android_translator.presentation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.domain.deprecated.MockTranslateUseCase;
import com.example.android_translator.domain.deprecated.TranslateUseCase;
import com.example.android_translator.domain.data_perform.TranslateFieldHandMockItems;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.presentation.view.MainView;

import java.util.List;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {

    private final TranslateUseCase translateUseCase;
    private final TranslateFieldHandMockItems translateFieldHandMockItems;

    public MainActivityPresenter() {
        this.translateUseCase = new MockTranslateUseCase();
        this.translateFieldHandMockItems = new TranslateFieldHandMockItems();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        List<TranslationField> data = translateFieldHandMockItems.getList(9);
        getViewState().initRecycler(data);
    }

    public void onTranslate(String word) {
        TranslationField translate = translateUseCase.translate(word);
    }
}
