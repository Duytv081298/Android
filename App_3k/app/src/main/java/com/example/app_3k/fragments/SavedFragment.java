package com.example.app_3k.fragments;

import com.example.app_3k.R;
import com.example.app_3k.base.BaseFragment;

public class SavedFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_saved;
    }

    @Override
    public String getTitle() {
        return "Saved";
    }
}
