package com.android.btvn_buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Random rd = new Random();
    private TextView txt_user;
    private TextView txt_time;
    //    private ArrayList<Box> boxs;
    private Button buttons[] = null;

    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
        initViews();

    }

    private void initViews() {
        txt_user = findViewById(R.id.txt_user);
        txt_time = findViewById(R.id.txt_time);

        buttons[0] = findViewById(R.id.btn_1_1);
        buttons[1] = findViewById(R.id.btn_1_2);
        buttons[2] = findViewById(R.id.btn_1_3);
        buttons[3] = findViewById(R.id.btn_2_1);
        buttons[4] = findViewById(R.id.btn_2_2);
        buttons[5] = findViewById(R.id.btn_2_3);
        buttons[6] = findViewById(R.id.btn_3_1);
        buttons[7] = findViewById(R.id.btn_3_2);
        buttons[8] = findViewById(R.id.btn_3_3);

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < 9; i++) {
            String text = rd.nextInt(10) +"";
            switch (v.getId()) {
                case R.id.btn_1_1:
                    buttons[0].setText(text);
                    break;
            }
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
