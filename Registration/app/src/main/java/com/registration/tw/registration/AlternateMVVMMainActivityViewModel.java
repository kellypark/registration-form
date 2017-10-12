package com.registration.tw.registration;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import java.lang.ref.WeakReference;

public class AlternateMVVMMainActivityViewModel extends BaseObservable {

    public final ObservableField<String> username =  new ObservableField<>("");
    public final ObservableField<String> email =  new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");
    public final ObservableField<Integer> snackbarText = new ObservableField<>();

    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_]*@[a-zA-Z0-9]*.com";
    private static final String PASSWORD_VALIDATION_REGEX = "^[a-zA-Z0-9_]{4,}";
    private WeakReference<AlternateMVVMMainActivityNavigator> navigator;

    public void onRegister() {
        String emailText = email.get();
        String usernameText = username.get();
        String passwordText = password.get();

        if (!emailText.isEmpty() && !usernameText.isEmpty() && !passwordText.isEmpty()) {
            if (!emailText.matches(EMAIL_VALIDATION_REGEX)) {
                snackbarText.set(R.string.email_validation_message);
            } else if (!passwordText.matches(PASSWORD_VALIDATION_REGEX)) {
                snackbarText.set(R.string.password_validation_message);
            } else {
                navigator.get().openSuccessActivity(usernameText, emailText, passwordText);
            }
        } else {
            snackbarText.set(R.string.mandatory_field_validation_message);
        }
    }

    public void setNavigator(AlternateMVVMMainActivityNavigator navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    Integer getSnackbarText() {
        return snackbarText.get();
    }

    public void onDestroy() {
        navigator = null;
    }
}
