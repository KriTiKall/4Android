package com.example.android_translator.domain.data_perform;

public abstract class Mapper<From, To> {
    protected abstract To mapImpl(From from);

    public To map(From from){
        return null;
    }
}
