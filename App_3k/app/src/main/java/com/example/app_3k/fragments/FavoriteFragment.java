package com.example.app_3k.fragments;

import com.example.app_3k.R;
import com.example.app_3k.base.BaseFragment;

public class FavoriteFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_favorite;
    }

    @Override
    public String getTitle() {
        return "Favorite";
    }
}
