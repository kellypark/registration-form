package com.registration.tw.registration;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationSuccessActivity extends AppCompatActivity {

    @BindView(R.id.welcomeMessage)
    TextView welcomeMessageField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_success);
        ButterKnife.bind(this);

        User registeredUser = (User) getIntent().getExtras().get(getString(R.string.REGISTERED_USER));
        welcomeMessageField.setText(this.getResources().getString(R.string.welcome_message, registeredUser.getUsername()));
    }
}
