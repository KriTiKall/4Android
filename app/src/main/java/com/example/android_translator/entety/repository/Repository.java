package com.example.android_translator.entety.repository;

import io.reactivex.Single;

public interface Repository<T> {
    public Single<T> all(String text);


}
