package com.android.buoi9.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.buoi9.MainActivity;
import com.android.buoi9.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "RegisterFragment";

    private EditText edtUser;
    private EditText edtPass;
    private Button btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.register , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUser = getActivity().findViewById(R.id.edt_Register_user);
        edtPass = getActivity().findViewById(R.id.edt_Register_password);

        btnRegister = getActivity().findViewById(R.id.btn_Register);

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
            case  R.id.btn_Register:

                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getContext(), "Dât empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                MainActivity act = (MainActivity) getActivity();

                act.getFmLogin().setData(user,pass);
                act.showFragment(act.getFmLogin());


                break;
        }

    }
}
