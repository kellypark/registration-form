package com.registration.tw.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpForm();
    }

    private void setUpForm() {
        // this is meant to look bad
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailField.getText().toString().equals("") &&
                        !usernameField.getText().toString().equals("") &&
                        !passwordField.getText().toString().equals("")) {
                    if(!emailField.getText().toString().matches(EMAIL_VALIDATION_REGEX)){
                        Snackbar snackbar = Snackbar.make(rootContainer, getString(R.string.emailValidationMessage), Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                    else if(!passwordField.getText().toString().matches(PASSWORD_VALIDATION_REGEX)){
                        Snackbar.make(rootContainer, getString(R.string.passwordValidationMessage), Snackbar.LENGTH_LONG).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, RegistrationSuccessActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Snackbar.make(rootContainer, getString(R.string.mandatoryFieldValidationMessage), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
