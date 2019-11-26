package com.example.test_app_3k.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewsAdapter extends FragmentPagerAdapter  {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private  final List<String> fragmentListTiles = new ArrayList<>();

    public ViewsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTiles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTiles.get(position);
    }
    public void AddFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentListTiles.add(title);
    }




}
