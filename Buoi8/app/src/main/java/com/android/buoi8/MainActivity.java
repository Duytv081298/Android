package com.android.buoi8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable, DownloadAsync.DownloadFileCallBack {
    private TextView tv_time;
    private Button btn_start;
    private Button btn_end;
    private boolean isRunning = false;
    private final int WHAT_TIME = 1;

    private TextView edt_download;
    private Button btn_download;
    private ImageView img_download;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        tv_time = findViewById(R.id.tv_time);
        btn_start = findViewById(R.id.btn_start);
        btn_end = findViewById(R.id.btn_end);
        edt_download = findViewById(R.id.edt_download);
        btn_download = findViewById(R.id.btn_download);
        img_download = findViewById(R.id.img_download);

        btn_start.setOnClickListener(this);
        btn_end.setOnClickListener(this);
        btn_download.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                isRunning = true;
                btn_start.setEnabled(false);
                Thread t = new Thread(this);
                t.start();
                break;
            case R.id.btn_end:
                btn_start.setEnabled(true);
                isRunning = false;
                break;
            case R.id.btn_download:
                String link = edt_download.getText().toString();
                DownloadAsync async = new DownloadAsync(this);
                async.execute(link);
                break;
        }
    }

    @Override
    public void run() {
        int i = 0;
        int t = 0;
        while (isRunning){
            i++;
            if (i == 60){
                t +=1;
                i -= 60;
            }
            Message msg = new Message();
            msg.what = WHAT_TIME ;
            msg.arg1 = t;
            msg.arg2 = i;
            handler.sendMessage(msg);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case WHAT_TIME:
                    tv_time.setText(msg.arg1 + " : " + msg.arg2);
                    break;
            }
        }
    };

    @Override
    public void onDonloadResult(Bitmap bitmap) {
        img_download.setImageBitmap(bitmap);

    }
}
