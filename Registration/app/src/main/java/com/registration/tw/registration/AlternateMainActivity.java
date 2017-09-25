package com.registration.tw.registration;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.registration.tw.registration.databinding.ActivityAlternateMainBinding;

public class AlternateMainActivity extends AppCompatActivity {

    private ActivityAlternateMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alternate_main);
        binding.setMain(this);
        binding.setViewModel(new AlternateMainActivityViewModel());
    }

    public void showSnackbar(int id) {
        hideSoftKeyboard();
        Snackbar.make(binding.root, getString(id), Snackbar.LENGTH_INDEFINITE).show();
    }

    public void goToSuccessActivity(String username, String email, String password) {
        Intent intent = new Intent(AlternateMainActivity.this, RegistrationSuccessActivity.class);
        intent.putExtra(getString(R.string.REGISTERED_USER), new User(username, email, password));
        startActivity(intent);
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
