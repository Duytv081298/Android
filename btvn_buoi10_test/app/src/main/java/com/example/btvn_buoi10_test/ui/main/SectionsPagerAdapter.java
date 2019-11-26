package com.example.btvn_buoi10_test.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.btvn_buoi10_test.R;
import com.example.btvn_buoi10_test.fragment.Favourite;
import com.example.btvn_buoi10_test.fragment.Newtt;
import com.example.btvn_buoi10_test.fragment.Saved;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.daluu, R.string.yeuthich, R.string.xoa};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Newtt();
                break;
            case 1:
                fragment = new Saved();
                break;
            case 2:
                fragment = new Favourite();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}