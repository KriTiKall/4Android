package com.example.android_translator.entety.repository;

import retrofit2.Call;

public interface Repository<T> {
    public Call<T> all(String text);
}
