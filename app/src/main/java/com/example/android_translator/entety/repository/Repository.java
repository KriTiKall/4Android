package com.example.android_translator.entety.repository;

import rx.Single;

public interface Repository<T> {
    public Single<T> all(String text);


}
