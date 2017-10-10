package com.registration.tw.registration;

public interface AlternateMVPMainView {

    void showEmailAddressFormatError();

    void showPasswordFormatError();

    void onSuccessRegistration(User user);

    void showMandatoryFieldError();
}
