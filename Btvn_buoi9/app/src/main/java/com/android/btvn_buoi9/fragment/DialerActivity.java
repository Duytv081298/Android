package com.android.btvn_buoi9.fragment;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.btvn_buoi9.R;

public class DialerActivity  extends Fragment implements View.OnClickListener {

    private String phoneNumber;

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSao, btnThang, btnDialer, btnDelete;
    private TextView tvPhoneNumber;

    private final String TAG = "DialerActivity";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.activity_dialer , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        tvPhoneNumber = getActivity().findViewById(R.id.tv_phone_number);
        btn0 = getActivity().findViewById(R.id.btn_number_0);
        btn1 = getActivity().findViewById(R.id.btn_number_1);
        btn2 = getActivity().findViewById(R.id.btn_number_2);
        btn3 = getActivity().findViewById(R.id.btn_number_3);
        btn4 = getActivity().findViewById(R.id.btn_number_4);
        btn5 = getActivity().findViewById(R.id.btn_number_5);
        btn6 = getActivity().findViewById(R.id.btn_number_6);
        btn7 = getActivity().findViewById(R.id.btn_number_7);
        btn8 = getActivity().findViewById(R.id.btn_number_8);
        btn9 = getActivity().findViewById(R.id.btn_number_9);
        btnSao = getActivity().findViewById(R.id.btn_number_sao);
        btnThang = getActivity().findViewById(R.id.btn_number_thang);
        btnDialer = getActivity().findViewById(R.id.btn_number_dialer);
        btnDelete = getActivity().findViewById(R.id.btn_number_delete);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSao.setOnClickListener(this);
        btnThang.setOnClickListener(this);
        btnDialer.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        phoneNumber = "";
    }

    private void numberClick(Button button) {
        phoneNumber += button.getText().toString();
        tvPhoneNumber.setText(phoneNumber);
    }
    private void delete() {
        if (phoneNumber.length() != 0) {
            phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
            tvPhoneNumber.setText(phoneNumber);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_number_0:
                numberClick(btn0);
                break;
            case R.id.btn_number_1:
                numberClick(btn1);
                break;
            case R.id.btn_number_2:
                numberClick(btn2);
                break;
            case R.id.btn_number_3:
                numberClick(btn3);
                break;
            case R.id.btn_number_4:
                numberClick(btn4);
                break;
            case R.id.btn_number_5:
                numberClick(btn5);
                break;
            case R.id.btn_number_6:
                numberClick(btn6);
                break;
            case R.id.btn_number_7:
                numberClick(btn7);
                break;
            case R.id.btn_number_8:
                numberClick(btn8);
                break;
            case R.id.btn_number_9:
                numberClick(btn9);
                break;
            case R.id.btn_number_sao:
                numberClick(btnSao);
                break;
            case R.id.btn_number_thang:
                numberClick(btnThang);
                break;
            case R.id.btn_number_dialer:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 10);
                    return;
                } else {
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_number_delete:
                delete();
                break;
        }
    }
}
