package com.android.buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_USER_NAME = "extra.user.name" ;
    public static final String EXTRA_PASSWORD = "extra.password";

    private final String TAG = "Register";
    private EditText edt_user_name;
    private EditText edt_password;
    private Button btn_ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Log.v(TAG,"onCreate");
        initViews();
    }

    private void initViews() {
        edt_user_name = findViewById(R.id.edt_user_name);
        edt_password = findViewById(R.id.edt_password);
        btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");

    }
    @Override
    public void onClick(View v) {
        String userName = edt_user_name.getText().toString();
        String password = edt_password.getText().toString();
        if (userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please input data",
                    Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_PASSWORD, password);
        setResult(RESULT_OK,  intent);
        finish(); // đóng activity
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
