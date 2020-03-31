package com.example.android_translator.entety.repository;

import com.example.android_translator.app.App;
import com.example.android_translator.domain.data_perform.TranslationField;
import com.example.android_translator.entety.dao.AppDataBase;

import java.util.List;

public class DataBaseRepository {

    private AppDataBase dataBase;

    public DataBaseRepository() {
        dataBase = App.getInstance().getAppDataBase();
    }

    public List<TranslationField> getAll(){
        return dataBase.daoAccess().getAll();
    }

    public void insert(TranslationField translation){
        dataBase.daoAccess().insert(translation);
    }

    public void update(TranslationField translation){
        dataBase.daoAccess().update(translation);
    }

    public void delete(TranslationField translation){
        dataBase.daoAccess().delete(translation);
    }
}