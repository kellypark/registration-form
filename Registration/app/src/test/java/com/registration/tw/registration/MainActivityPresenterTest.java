package com.registration.tw.registration;

import com.registration.tw.registration.mvc.MainActivityPresenter;
import com.registration.tw.registration.mvc.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    private MainActivityPresenter presenter;

    @Mock
    MainActivityView view;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter();
        presenter.setView(view);
    }

    @Test
    public void shouldDisplayMandatoryFieldErrorWhenEmailIsEmpty() throws Exception {
        presenter.onRegister("user", "", "password");

        verify(view).displayMandatoryFieldError();
    }
}