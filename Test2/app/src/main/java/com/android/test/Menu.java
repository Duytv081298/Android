package com.android.test;

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

public class Menu extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_USER_NAME = "extra.user.name" ;
    private EditText edt_User;
    private TextView txt_Kg;
    private Button btn_Start;
    private final String TAG = "Menu";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        Log.v(TAG, "onCreate");
        initViews();
    }

    private void initViews() {
        edt_User = findViewById(R.id.edt_user_name);
        txt_Kg = findViewById(R.id.txt_kq);
        btn_Start = findViewById(R.id.btn_start);

        btn_Start.setOnClickListener(this);

        Intent intent = getIntent();
        String winLose = intent.getStringExtra(MainActivity.EXTRA_RESULT);
        txt_Kg.setText(winLose);
    }

    @Override
    public void onClick(View v) {
        String userName = edt_User.getText().toString();
        if (userName.isEmpty()){
            Toast.makeText(this,"Data empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(EXTRA_USER_NAME, userName);
        startActivity(i);
        finish();
    }
}
