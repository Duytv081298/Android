package com.example.chatt3h.activity.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.chatt3h.R;
import com.example.chatt3h.activity.register.RegisterActivity;
import com.example.chatt3h.databinding.LoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private static final int REQUEST_REGISTER = 1;
    public static final String EXTRA_USER_NAME = "extra.user.name";
    public static final String EXTRA_PASSWORD = "extra.password";
    private LoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.login
        );
        binding.setListener(this);
    }

    @Override
    public void onLoginClicked() {

    }

    @Override
    public void onRegisterClicked() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {
                String userName = data.getStringExtra(EXTRA_USER_NAME);
                String password = data.getStringExtra(EXTRA_PASSWORD);
                binding.edtPassword.setText(password);
                binding.edtUserName.setText(userName);
            }
        }
    }
}
