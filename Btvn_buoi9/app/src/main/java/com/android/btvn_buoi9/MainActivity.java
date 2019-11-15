package com.android.btvn_buoi9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.android.btvn_buoi9.fragment.DialerActivity;
import com.android.btvn_buoi9.fragment.HomeActivity;
import com.android.btvn_buoi9.fragment.ImageActivity;

public class MainActivity extends AppCompatActivity {

    private HomeActivity fmHome = new HomeActivity();
    private DialerActivity fmDialer = new DialerActivity();
    private ImageActivity fmImage = new ImageActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        showFragment(fmHome);
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container , fmHome);
        transaction.add(R.id.container , fmDialer);
        transaction.add(R.id.container , fmImage);
        transaction.commit();
    }

    public void showFragment(Fragment fmshow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fmHome);
        transaction.hide(fmDialer);
        transaction.hide(fmImage);
        transaction.show(fmshow);
        transaction.commit();
    }

    public DialerActivity getFmDialer() {
        return fmDialer;
    }

    public ImageActivity getFmImage() {
        return fmImage;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showFragment(this.fmHome);
        }
        return super.onKeyDown(keyCode, event);
    }
}
