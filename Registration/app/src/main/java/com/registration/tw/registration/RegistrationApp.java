package com.registration.tw.registration;

import android.app.Application;

import com.registration.tw.registration.data.ActivityComponent;
import com.registration.tw.registration.data.ActivityModule;
import com.registration.tw.registration.data.DaggerActivityComponent;


public class RegistrationApp extends Application {
    private ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
