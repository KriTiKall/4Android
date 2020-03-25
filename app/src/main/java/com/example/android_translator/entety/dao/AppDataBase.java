package com.example.android_translator.entety.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.android_translator.domain.data_perform.TranslationField;

@Database(entities = {TranslationField.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TranslationFieldDao daoAccess();
}
