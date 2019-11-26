package com.example.test_app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_app.MainActivity;
import com.example.test_app.R;
import com.example.test_app.adapter.NewsAdapter;
import com.example.test_app.models.News;

import java.util.ArrayList;

public class Newtt extends Fragment {

    private final String TAG = "Newtt";
    private RecyclerView recyclerNew;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"On create view");
        return inflater.inflate(R.layout.activitity_newstt, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"On onActivityCreated");
        recyclerNew = getActivity().findViewById(R.id.new_tt);

        MainActivity mainActivity = (MainActivity) getActivity();
        recyclerNew.setAdapter(mainActivity.getAdapter());
        super.onActivityCreated(savedInstanceState);
    }
}
