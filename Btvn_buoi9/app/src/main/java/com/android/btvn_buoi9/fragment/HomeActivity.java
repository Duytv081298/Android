package com.android.btvn_buoi9.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.btvn_buoi9.MainActivity;
import com.android.btvn_buoi9.R;

import java.text.SimpleDateFormat;

import static android.app.Activity.RESULT_OK;

public class HomeActivity extends Fragment implements View.OnClickListener, Runnable {

    public static final int REQUEST_IMAGE = 3;
    private static final int REQUEST_LOAD_IMAGE = 1;
    private final int WHAT_TIME = 1;
    private final String TAG = "HomeActivity";

    private TextView time;
    private TextView day;

    private RelativeLayout dialer;
    private RelativeLayout messaging;
    private RelativeLayout contacts;
    private RelativeLayout camera;
    private RelativeLayout music;
    private RelativeLayout gallery;

    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.activity_home, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        time = getActivity().findViewById(R.id.time);
        day = getActivity().findViewById(R.id.day);

        dialer = getActivity().findViewById(R.id.dialer);
        messaging = getActivity().findViewById(R.id.messaging);
        contacts = getActivity().findViewById(R.id.contacts);
        camera = getActivity().findViewById(R.id.camera);
        music = getActivity().findViewById(R.id.music);
        gallery = getActivity().findViewById(R.id.gallery);

        dialer.setOnClickListener(this);
        messaging.setOnClickListener(this);
        contacts.setOnClickListener(this);
        camera.setOnClickListener(this);
        music.setOnClickListener(this);
        gallery.setOnClickListener(this);


        Thread t = new Thread(this);
        t.start();

        getContext();
        getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialer:
                MainActivity act = (MainActivity) getActivity();
                act.showFragment(act.getFmDialer());
                break;
            case R.id.messaging:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                startActivity(intent);
                break;
            case R.id.contacts:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                startActivity(intent);
                break;
            case R.id.camera:
                intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
                break;
            case R.id.music:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MUSIC);
                startActivity(intent);
                break;
            case R.id.gallery:
                intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_LOAD_IMAGE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOAD_IMAGE && resultCode == RESULT_OK ) {
            Uri img = data.getData();
            MainActivity act = (MainActivity) getActivity();
            act.showFragment(act.getFmImage());
            act.getFmImage().getImGallery().setImageURI(img);
        }
    }

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatH = new SimpleDateFormat("HH");
        while (true) {
            long current = System.currentTimeMillis();
            String time = format.format(current);
            int timeH = Integer.parseInt(formatH.format(current));
            Message msg = new Message();
            msg.what = WHAT_TIME;
            msg.obj = time;
            msg.arg1 = 1;
            handler.sendMessage(msg);
            if (timeH >= 13) {
                msg.arg1 = 2;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_TIME:
                    time.setText(msg.obj + "");
                    if (msg.arg1 == 2) {
                        day.setText("Afternoon");
                    } else {
                        day.setText("Morning");
                    }
                    break;
            }
        }
    };
}
