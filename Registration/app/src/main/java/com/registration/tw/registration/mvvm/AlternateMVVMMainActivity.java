package com.registration.tw.registration.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.registration.tw.registration.R;
import com.registration.tw.registration.RegistrationSuccessActivity;
import com.registration.tw.registration.User;
import com.registration.tw.registration.databinding.ActivityAlternateMainBinding;

public class AlternateMVVMMainActivity extends AppCompatActivity implements AlternateMVVMMainActivityNavigator {

    private ActivityAlternateMainBinding binding;
    private AlternateMVVMMainActivityViewModel viewModel;
    private Observable.OnPropertyChangedCallback snackbarCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alternate_main);
        viewModel = new AlternateMVVMMainActivityViewModel();
        viewModel.setNavigator(this);
        binding.setViewModel(viewModel);
        snackbarCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                showSnackbar(viewModel.getSnackbarText());
            }
        };
        viewModel.snackbarText.addOnPropertyChangedCallback(snackbarCallback);
    }

    @Override
    protected void onDestroy() {
        if (snackbarCallback != null) {
            viewModel.snackbarText.removeOnPropertyChangedCallback(snackbarCallback);
        }
        viewModel.onDestroy();
        super.onDestroy();
    }

    public void showSnackbar(int id) {
        hideSoftKeyboard();
        Snackbar.make(binding.root, getString(id), Snackbar.LENGTH_INDEFINITE).show();
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public void openSuccessActivity(String username, String email, String password) {
        Intent intent = new Intent(AlternateMVVMMainActivity.this, RegistrationSuccessActivity.class);
        intent.putExtra(getString(R.string.REGISTERED_USER), new User(username, email, password));
        startActivity(intent);
    }
}
