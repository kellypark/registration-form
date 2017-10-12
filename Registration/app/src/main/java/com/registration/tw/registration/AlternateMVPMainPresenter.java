package com.registration.tw.registration;

public class AlternateMVPMainPresenter {
    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_]*@[a-zA-Z0-9]*.com";
    public static final String PASSWORD_VALIDATION_REGEX = "^[a-zA-Z0-9_]{4,}";

    private AlternateMVPMainView view;

    public void setView(AlternateMVPMainView activity) {
        this.view = activity;
    }

    public void registerUser(String email, String username, String password) {
        if (!email.isEmpty() &&
                !username.isEmpty() &&
                !password.isEmpty()) {
            if(!email.matches(EMAIL_VALIDATION_REGEX)){
                view.showEmailAddressFormatError();
            }
            else if(!password.matches(PASSWORD_VALIDATION_REGEX)){
                view.showPasswordFormatError();
            }
            else {
                User user = new User(username, email, password);
                view.onSuccessRegistration(user);
            }

        } else {
            view.showMandatoryFieldError();

        }
    }
}
