package com.registration.tw.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_]*@[a-zA-Z0-9]*.com";
    public static final String PASSWORD_VALIDATION_REGEX = "^[a-zA-Z0-9_]{4,}";
    @BindView(R.id.registerButton)
    Button registerButton;

    @BindView(R.id.emailField)
    EditText emailField;

    @BindView(R.id.usernameField)
    EditText usernameField;

    @BindView(R.id.passwordField)
    EditText passwordField;

    @BindView(R.id.root)
    LinearLayout rootContainer;

    @BindView(R.id.registrationInstruction)
    TextView registrationInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((RegistrationApp) getApplication()).getActivityComponent().inject(this);
        setUpForm();
    }

    private void setUpForm() {
        // this is meant to look bad
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                String username = usernameField.getText().toString();
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                if (!email.isEmpty() &&
                        !username.isEmpty() &&
                        !password.isEmpty()) {
                    if(!email.matches(EMAIL_VALIDATION_REGEX)){
                        showSnackbar(R.string.email_validation_message);
                    }
                    else if(!password.matches(PASSWORD_VALIDATION_REGEX)){
                        showSnackbar(R.string.password_validation_message);
                    }
                    else {

                        Intent intent = new Intent(MainActivity.this, RegistrationSuccessActivity.class);
                        intent.putExtra(getString(R.string.REGISTERED_USER), new User(username, email, password));
                        startActivity(intent);
                    }
                } else {
                    showSnackbar(R.string.mandatory_field_validation_message);
                }
            }
        });
    }

    private void showSnackbar(int id) {
        Snackbar.make(rootContainer, getString(id), Snackbar.LENGTH_INDEFINITE).show();
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
