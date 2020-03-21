package com.example.android_translator.domain.data_perform;

import com.example.android_translator.entety.repository.DataBaseRepository;

import java.util.List;

public class DataBaseMockItems implements MockItems<TranslationField>{
    private DataBaseRepository repository;

    public DataBaseMockItems() {
        this.repository = new DataBaseRepository();
    }

    @Override
    public List<TranslationField> getList(int length) {
        return null;
    }

    public List<TranslationField> getAll(){
        return repository.getAll();
    }
}
