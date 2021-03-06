package com.example.android_translator.domain.data_perform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TranslationFieldMockItems implements MockItems<TranslationField> {

    /**
     * Method for test filling recycler by translation field
     *
     * @param length
     * @return
     */
    @Override
    public List<TranslationField> getList(int length) {
        List<TranslationField> list = new ArrayList();
        for (int i = 0; i < length; i++)
            list.add(new TranslationField("concurrency", "совпадения"));
        return list;
    }

    @Override
    public List<TranslationField> getAll() {
        return null;
    }
}
