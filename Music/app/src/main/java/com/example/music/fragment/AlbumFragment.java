package com.example.music.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.music.R;
import com.example.music.base.BaseFragment;

public class AlbumFragment extends BaseFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_album;
    }

    @Override
    public String getTitle() {
        return "Album";
    }
}
