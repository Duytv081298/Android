package com.example.chatt3h.activity.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.chatt3h.R;
import com.example.chatt3h.activity.login.LoginActivity;
import com.example.chatt3h.databinding.RegisterBinding;

public class RegisterActivity  extends AppCompatActivity implements RegisterListener {

    private RegisterBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.register);
        binding.setListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onRegisterClicked() {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String name = binding.edtName.getText().toString();
        Intent data = new Intent();
        data.putExtra(LoginActivity.EXTRA_USER_NAME, userName);
        data.putExtra(LoginActivity.EXTRA_PASSWORD, password);
        setResult(RESULT_OK, data);
        finish();
    }

}
