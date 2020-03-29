package com.example.android_translator.entety.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.List;

@Dao
public interface TranslationFieldDao {

    @Query("SELECT * FROM translationField")
    List<TranslationField> getAll();

    @Query("DELETE FROM translationField")
    void deleteAll();

    @Insert
    void insert(TranslationField translation);

    @Update
    void update(TranslationField translation);

    @Delete
    void delete(TranslationField translation);
}
