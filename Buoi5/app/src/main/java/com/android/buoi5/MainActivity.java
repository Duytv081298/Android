package com.android.buoi5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_IMAGE = 1;
    private TextView tvInfo;
    private EditText edtValue;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnGalley;
    private ImageView imgGalley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitViews();

    }

    private void innitViews() {
        tvInfo = findViewById(R.id.tv_info);
        edtValue = findViewById(R.id.edt_value);
        btnCall = findViewById(R.id.btn_call);
        btnBrowser = findViewById(R.id.btn_browser);
        btnGalley = findViewById(R.id.btn_galley);
        imgGalley = findViewById(R.id.img_galley);

        btnBrowser.setOnClickListener(this);
        btnGalley.setOnClickListener(this);
        imgGalley.setOnClickListener(this);

        Intent intent = getIntent();

        String userName = intent.getStringExtra(Register.EXTRA_USER_NAME);
        String password = intent.getStringExtra(Register.EXTRA_PASSWORD);
        tvInfo.setText( "User Name : " + userName + " - Password : " +password);
    }

    @Override
    public void onClick(View v) {
        String value = edtValue.getText().toString();

        switch (v.getId()){
            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + value);
                call.setData(uri);
                startActivity(call);


                break;
            case R.id.btn_browser:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(value));
                startActivity(browser);
                break;
            case R.id.btn_galley:
                Intent galley = new Intent(Intent.ACTION_GET_CONTENT);
                galley.setType("image/*");
                startActivityForResult(Intent.createChooser(galley,"Pick image"),REQUEST_IMAGE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE){
            if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                imgGalley.setImageURI(uri);
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
