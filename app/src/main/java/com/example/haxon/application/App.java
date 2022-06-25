package com.example.haxon.application;

import android.util.Log;

import androidx.multidex.MultiDexApplication;

import dagger.android.AndroidInjector;
import dagger.android.HasAndroidInjector;

public class App extends MultiDexApplication implements HasAndroidInjector {
    @Override
    public AndroidInjector<Object> androidInjector() {
        Log.d("TAG", "App.java:androidInjector: ");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "App.java:onCreate: ");
    }
}
