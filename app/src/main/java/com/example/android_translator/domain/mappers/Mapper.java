package com.example.android_translator.domain.mappers;

public abstract class Mapper<From, To> {

    public To map(From item) {
        if (item == null) {
            return null;
        }
        return mapImp(item);
    }

    protected abstract To mapImp(From item);
}
