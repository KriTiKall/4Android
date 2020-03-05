package com.example.android_translator.domain;

public abstract class Mapper<From, To> {

    protected abstract To mapImpl(From from);

    public To map(From from) {
        return null;
    }
}
