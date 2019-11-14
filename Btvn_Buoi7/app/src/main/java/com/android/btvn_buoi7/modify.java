package com.android.btvn_buoi7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.android.btvn_buoi7.add.EXTRA_NAME;
import static com.android.btvn_buoi7.add.EXTRA_POINT;
import static com.android.btvn_buoi7.add.EXTRA_SUBJECT;

public class modify extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_name;
    private EditText edt_subjects;
    private EditText edt_point;
    private Button btn_modify;
    private Button btn_cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_item);
        initView();
    }

    private void initView() {
        edt_name = findViewById(R.id.edt_name);
        edt_subjects = findViewById(R.id.edt_subjects);
        edt_point = findViewById(R.id.edt_point);
        btn_modify = findViewById(R.id.btn_modify);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_modify.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        Intent intent = getIntent();


        String name = intent.getStringExtra(EXTRA_NAME);
        String subjects = intent.getStringExtra(EXTRA_SUBJECT);
        String point = intent.getStringExtra(EXTRA_POINT);

        edt_name.setText(name);
        edt_subjects.setText(subjects);
        edt_point.setText(point);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_modify:

                String name = edt_name.getText().toString();
                String subjects = edt_subjects.getText().toString();
                String point = edt_point.getText().toString();
                if (name.isEmpty() || subjects.isEmpty() || point.isEmpty()) {
                    Toast.makeText(this, "Please input data",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(add.EXTRA_NAME, name);
                intent.putExtra(add.EXTRA_SUBJECT, subjects);
                intent.putExtra(add.EXTRA_POINT, point);
                setResult(2, intent);
                finish();
                break;
            case R.id.btn_cancel:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivityForResult(intent1,add.REQUEST_MAIN);
                break;
        }
    }





}
