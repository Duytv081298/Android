package com.example.test_app_3k.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_app_3k.R;
import com.example.test_app_3k.adapter.NewsAdapter;

public class Newtt extends Fragment {

    private RecyclerView lvCell;
    private NewsAdapter newAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activitity_newstt, container, false);
        lvCell = v.findViewById(R.id.new_tt);
        return v;
    }
}
