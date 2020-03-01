package com.example.android_translator.domain.data_perform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TranslateFieldHandMockItems implements MockItems<TranslationField> {
    private final String[] word = {
            "foreword", "required", "relate", "familiar", "either", "distinct"
    };

    private final String[] translate = {
            "предсловие", "требуемый", "относиться", "знакомый", "любой", "отчетливый"
    };

    @Override
    public List<TranslationField> getList(int length) {
        List<TranslationField> list = new ArrayList();
        for(int i = 0; i < length; i++)
            list.add(new TranslationField(i, word[i % 5], translate[i % 5]));
        return list;
    }
}
