package com.example.android_translator.entety;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android_translator.domain.data_perform.TranslationField;

import java.util.List;

@androidx.room.Dao
public interface TranslationFieldDao {

    @Query("SELECT * FROM translationField")
    List<TranslationField> getAll();

    @Query("SELECT * FROM translationField WHERE id = :id")
    TranslationField getById(long id);

    @Query("SELECT id FROM translationField")
    List<Integer> getAllId();

    @Insert
    void insert(TranslationField translation);

    @Update
    void update(TranslationField translation);

    @Delete
    void delete(TranslationField translation);
}
