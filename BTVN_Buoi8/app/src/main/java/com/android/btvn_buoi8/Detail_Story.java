package com.android.btvn_buoi8;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Story extends AppCompatActivity implements View.OnClickListener{
    public static String POSITION = "extra.position";

    private ImageView profile_image;
    private TextView ten;
    private TextView tacgia;
    private TextView theLoai;
    private TextView chuong;
    private TextView ngayUp;
    private TextView ncn;
    private TextView noiDung;
    private ImageView back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_detail_activity);
        initView();
    }

    private void initView() {
        profile_image = findViewById(R.id.profile_image);
        ten = findViewById(R.id.ten);
        tacgia = findViewById(R.id.tacgia);
        theLoai = findViewById(R.id.theloai);
        chuong = findViewById(R.id.chuong);
        ngayUp = findViewById(R.id.ngayup);
        ncn = findViewById(R.id.ncn);
        noiDung = findViewById(R.id.noidung);
        back = findViewById(R.id.back);
        Intent intent = getIntent();

        back.setOnClickListener(this);

        int position =  Integer.parseInt(intent.getStringExtra(POSITION));

        profile_image = findViewById(R.id.profile_image);
        ten.setText(MainActivity.LISTSTORY.get(position).getTen());
        tacgia.setText(MainActivity.LISTSTORY.get(position).getTacgia());
        theLoai.setText(MainActivity.LISTSTORY.get(position).getTheLoai());
        chuong.setText(MainActivity.LISTSTORY.get(position).getChuong());
        ngayUp.setText(MainActivity.LISTSTORY.get(position).getNgayup());
        ncn.setText(MainActivity.LISTSTORY.get(position).getNcn());
        noiDung.setText(MainActivity.LISTSTORY.get(position).getNoiDung());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
