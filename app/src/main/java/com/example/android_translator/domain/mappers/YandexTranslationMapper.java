package com.example.android_translator.domain.mappers;

import com.example.android_translator.domain.essences.PossibleTranslation;
import com.example.android_translator.entety.essences.YandexTranslationJson;

public class YandexTranslationMapper extends Mapper<YandexTranslationJson, PossibleTranslation>{

    @Override
    protected PossibleTranslation mapImp(YandexTranslationJson item) {
        return new PossibleTranslation(item.getPosTranslate());
    }
}
