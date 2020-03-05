package com.example.android_translator.app;

import android.app.Application;

import androidx.room.Room;

import com.example.android_translator.entety.AppDataBase;

public class App extends Application {

    private static App instance;
    private AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDataBase = Room.databaseBuilder(this, AppDataBase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDataBase getAppDataBase() {
        return appDataBase;
    }
}
