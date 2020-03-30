package com.example.android_translator.entety.repository;

import retrofit2.Call;
import rx.Single;

public interface Repository<T> {
    public Call<T> all(String text);
}
