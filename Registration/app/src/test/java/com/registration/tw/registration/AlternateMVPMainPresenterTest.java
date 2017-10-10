package com.registration.tw.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlternateMVPMainPresenterTest {

    @InjectMocks
    AlternateMVPMainPresenter presenter;

    @Mock
    AlternateMVPMainView view;

    @Test
    public void shouldShowMandatoryFieldErrorWhenMissingEmail() throws Exception {
        presenter.registerUser("", "username", "password");
        verify(view).showMandatoryFieldError();
    }

    @Test
    public void shouldShowMandatoryFieldErrorWhenMissingUsername() throws Exception {
        presenter.registerUser("email", "", "password");
        verify(view).showMandatoryFieldError();
    }

    @Test
    public void shouldShowMandatoryFieldErrorWhenMissingPassword() throws Exception {
        presenter.registerUser("email", "username", "");
        verify(view).showMandatoryFieldError();
    }


    @Test
    public void shouldShowEmailValidationErrorWhenEmailPatternIsInvalid() throws Exception {
        presenter.registerUser("email", "username", "password");
        verify(view).showEmailAddressFormatError();
    }

    @Test
    public void shouldShowPasswordValidationErrorWhenIsTooShort() throws Exception {
        presenter.registerUser("email@test.com", "username", "abc");
        verify(view).showPasswordFormatError();
    }

    @Test
    public void shouldSuccessfullyRegisterAnUser() throws Exception {
        presenter.registerUser("email@test.com", "username", "abcd");
        verify(view).onSuccessRegistration(any(User.class));
    }
}