package com.registration.tw.registration.data;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class})
public interface ActivityComponent {
    void inject(AppCompatActivity activity);
}