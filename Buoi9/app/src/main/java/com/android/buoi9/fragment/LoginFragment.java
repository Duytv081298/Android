package com.android.buoi9.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.buoi9.MainActivity;
import com.android.buoi9.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "LoginFragment";
    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    private Button btnRegister;



    public boolean activeRegister = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.login , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUser = getActivity().findViewById(R.id.edt_user);
        edtPass = getActivity().findViewById(R.id.edt_password);

        btnLogin = getActivity().findViewById(R.id.btn_Login);
        btnRegister = getActivity().findViewById(R.id.btn_Login_Register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.btn_Login:
                break;
            case  R.id.btn_Login_Register:
                MainActivity act = (MainActivity) getActivity();
                act.showFragment(act.getFmRegister());
                break;
        }
    }

    public void setData(String user, String pass){
        edtUser.setText(user);
        edtPass.setText(pass);
    }
}
