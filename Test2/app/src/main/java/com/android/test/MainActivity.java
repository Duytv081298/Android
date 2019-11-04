package com.android.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_RESULT = "extra.result";
    private int TOTALSCORE;
    private Random rd = new Random();
    private TextView txt_user;
    private int counter = 5;


    private TextView txt_time;
    private Button buttons[] = new Button[9];
    private final String TAG = "MainActivity";
    int text;
    private boolean gameComplete;
    private boolean isWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
        initViews();
    }

    private void initViews() {
        TOTALSCORE = 0;
        text = 0;
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

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_time.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
                txt_time.setText(String.valueOf(counter));
                if (TOTALSCORE < 20) {
                    for (Button b : buttons) {
                        b.setEnabled(false);
                    }
                    gameComplete = true;
                }
            }
        }.start();
        Intent intent = getIntent();

        String userName = intent.getStringExtra(Menu.EXTRA_USER_NAME);
        txt_user.setText(userName);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (gameComplete == false) {
                Toast.makeText(this, "Must complete the game", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                if (isWin) {
                    String result = "You Win";
                    Intent intent = new Intent(this, Menu.class);
                    intent.putExtra(MainActivity.EXTRA_RESULT, result);
                    startActivity(intent);
                    finish();
                } else {
                    String result = "You Lose";
                    Intent intent = new Intent(this, Menu.class);
                    intent.putExtra(MainActivity.EXTRA_RESULT, result);
                    startActivity(intent);
                    finish();
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        text = rd.nextInt(10);
        switch (v.getId()) {
            case R.id.btn_1_1:
                clickbtn(0);
                break;
            case R.id.btn_1_2:
                clickbtn(1);
                break;
            case R.id.btn_1_3:
                clickbtn(2);
                break;
            case R.id.btn_2_1:
                clickbtn(3);
                break;
            case R.id.btn_2_2:
                clickbtn(4);
                break;
            case R.id.btn_2_3:
                clickbtn(5);
                break;
            case R.id.btn_3_1:
                clickbtn(6);
                break;
            case R.id.btn_3_2:
                clickbtn(7);
                break;
            case R.id.btn_3_3:
                clickbtn(8);
                break;
        }

    }

    private void clickbtn(int a) {
        buttons[a].setBackgroundColor(Color.CYAN);
        buttons[a].setText(text + "");
        TOTALSCORE += text;
        if (TOTALSCORE >= 20) {
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            for (Button b : buttons) {
                b.setEnabled(false);
            }
            isWin = true;
            gameComplete = true;
        } else if (counter == 0) {
            Toast.makeText(this, "YOU LOSE", Toast.LENGTH_SHORT).show();
        }

        buttons[a].setEnabled(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
