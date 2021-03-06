package com.registration.tw.registration.data;

import com.registration.tw.registration.mvp.AlternateMVPMainActivity;
import com.registration.tw.registration.mvc.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(AlternateMVPMainActivity activity);
}