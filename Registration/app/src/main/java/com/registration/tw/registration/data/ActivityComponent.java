package com.registration.tw.registration.data;

import com.registration.tw.registration.AlternateMVPMainActivity;
import com.registration.tw.registration.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(AlternateMVPMainActivity activity);
}