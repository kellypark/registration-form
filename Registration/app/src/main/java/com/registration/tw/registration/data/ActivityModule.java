package com.registration.tw.registration.data;

import com.registration.tw.registration.mvp.AlternateMVPMainPresenter;
import com.registration.tw.registration.mvc.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    public MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter();
    }

    @Provides
    public AlternateMVPMainPresenter provideAlternateMVPMainPresenter() {
        return new AlternateMVPMainPresenter();
    }
}