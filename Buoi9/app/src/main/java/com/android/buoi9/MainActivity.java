package com.android.buoi9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.buoi9.fragment.LoginFragment;
import com.android.buoi9.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    private LoginFragment fmLogin = new LoginFragment();

    private RegisterFragment fmRegister = new RegisterFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        showFragment(fmLogin);


    }


    private void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container , fmLogin);
        transaction.add(R.id.container , fmRegister);
        transaction.commit();
    }

    public void showFragment (Fragment fmshow){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//        transaction.replace(R.id.container , fmshow);
        transaction.hide(fmLogin);
        transaction.hide(fmRegister);
        transaction.show(fmshow);
        transaction.commit();

    }

    public LoginFragment getFmLogin() {
        return fmLogin;
    }

    public RegisterFragment getFmRegister() {
        return fmRegister;
    }
}
