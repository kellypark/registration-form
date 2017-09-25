package com.registration.tw.registration;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class AlternateMainActivityViewModel extends BaseObservable {

    public final ObservableField<String> username =  new ObservableField<>("");
    public final ObservableField<String> email =  new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");

    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_]*@[a-zA-Z0-9]*.com";
    private static final String PASSWORD_VALIDATION_REGEX = "^[a-zA-Z0-9_]{4,}";

    public void onRegister(AlternateMainActivity alternateMainActivity) {
        String emailText = email.get();
        String usernameText = username.get();
        String passwordText = password.get();

        if (!emailText.isEmpty() && !usernameText.isEmpty() && !passwordText.isEmpty()) {
            if (!emailText.matches(EMAIL_VALIDATION_REGEX)) {
                alternateMainActivity.showSnackbar(R.string.email_validation_message);
            } else if (!passwordText.matches(PASSWORD_VALIDATION_REGEX)) {
                alternateMainActivity.showSnackbar(R.string.password_validation_message);
            } else {
                alternateMainActivity.goToSuccessActivity(usernameText, emailText, passwordText);
            }
        } else {
            alternateMainActivity.showSnackbar(R.string.mandatory_field_validation_message);
        }
    }


}
