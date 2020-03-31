package com.example.android_translator.presentation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.android_translator.app.App;
import com.example.android_translator.domain.usecase.YandexTranslationUseCaseImp;
import com.example.android_translator.entety.dao.TranslationFieldDao;
import com.example.android_translator.entety.repository.YandexTranslationRepository;
import com.example.android_translator.presentation.view.ChangeView;

@InjectViewState
public class ChangeActivityPresenter extends MvpPresenter<ChangeView> {

    private final YandexTranslationUseCaseImp yandexTranslationUseCaseImp;

    private TranslationFieldDao database = App.getInstance()
            .getAppDataBase()
            .daoAccess();

    public ChangeActivityPresenter() {
        this.yandexTranslationUseCaseImp = new YandexTranslationUseCaseImp(new YandexTranslationRepository());
    }

    public TranslationFieldDao getDatabase() {
        return database;
    }

    public void deleteById(int id) {
        database.deleteById(id);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }
}
