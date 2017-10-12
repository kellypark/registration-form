package com.registration.tw.registration.mvp;

import com.registration.tw.registration.User;

public interface AlternateMVPMainView {

    void showEmailAddressFormatError();

    void showPasswordFormatError();

    void onSuccessRegistration(User user);

    void showMandatoryFieldError();
}
