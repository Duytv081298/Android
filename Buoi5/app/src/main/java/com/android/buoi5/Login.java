package com.android.buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_REGISTER = 1;
    private final String TAG = "Login";
    private EditText edt_user_name;
    private EditText edt_password;
    private Button btn_login;
    private Button btn_register;
    private Button btn_ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Log.v(TAG, "onCreate");
        initViews();
    }

    private void initViews() {
        edt_user_name = findViewById(R.id.edt_user_name);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String userName = edt_user_name.getText().toString();
                String password = edt_password.getText().toString();
                if (userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(this,"Data empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra(Register.EXTRA_USER_NAME, userName);
                i.putExtra(Register.EXTRA_PASSWORD, password);
                startActivity(i);
                finish();
                break;
            case R.id.btn_register:
                Intent intent = new Intent(this, Register.class);
                startActivityForResult(intent, REQUEST_REGISTER);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER){
            if (resultCode == RESULT_OK){
                String userName = data.getStringExtra(Register.EXTRA_USER_NAME);
                String password = data.getStringExtra(Register.EXTRA_PASSWORD);
                System.out.println("name : sssssssss" );
                edt_user_name.setText(userName);
                edt_password.setText(password);
            }else {
                Toast.makeText(this, "Register cancelled",Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
