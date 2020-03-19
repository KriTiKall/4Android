package com.example.android_translator.entety.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android_translator.domain.data_perform.TranslationField;

@Database(entities = {TranslationField.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TranslationField translationDao();
}
