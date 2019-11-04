package com.android.btvn_buoi7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class add extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_NAME = "extra.name";
    public static final String EXTRA_SUBJECT = "extra.subject";
    public static final String EXTRA_POINT = "extra.point";
    public static final int REQUEST_MAIN = 1;

    private EditText edt_name;
    private EditText edt_subjects;
    private EditText edt_point;
    private Button btn_add;
    private Button btn_cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        initView();
    }

    private void initView() {
        edt_name = findViewById(R.id.edt_name);
        edt_subjects = findViewById(R.id.edt_subjects);
        edt_point = findViewById(R.id.edt_point);
        btn_add = findViewById(R.id.btn_add);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_add.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:

                String name = edt_name.getText().toString();
                String subjects = edt_subjects.getText().toString();
                String point = edt_point.getText().toString();
                if (name.isEmpty() || subjects.isEmpty() || point.isEmpty()) {
                    Toast.makeText(this, "Please input data",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(EXTRA_NAME, name);
                intent.putExtra(EXTRA_SUBJECT, subjects);
                intent.putExtra(EXTRA_POINT, point);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_cancel:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivityForResult(intent1,REQUEST_MAIN);
                break;
        }
    }

}
