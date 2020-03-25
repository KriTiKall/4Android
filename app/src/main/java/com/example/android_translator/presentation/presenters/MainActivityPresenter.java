package com.example.android_translator.presentation.presenters;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.R;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.DataBaseMockItems;
import com.example.android_translator.domain.data_perform.MockItems;
import com.example.android_translator.domain.deprecated.MockTranslateUseCase;
import com.example.android_translator.domain.deprecated.TranslateUseCase;
import com.example.android_translator.domain.data_perform.TranslateFieldHandMockItems;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.repository.DataBaseRepository;
import com.example.android_translator.presentation.view.MainView;

import java.util.List;
import java.util.UUID;

import butterknife.OnClick;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {

    private final TranslateUseCase translateUseCase;
    private final MockItems items;

    public MainActivityPresenter() {
        this.translateUseCase = new MockTranslateUseCase();
        this.items = new DataBaseMockItems();
        //this.items = new TranslateFieldHandMockItems();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        List<TranslationField> data = items.getAll();
        getViewState().initRecycler(data);
    }

    public void onTranslate(String word) {
        TranslationField translate = translateUseCase.translate(word);
    }
}
