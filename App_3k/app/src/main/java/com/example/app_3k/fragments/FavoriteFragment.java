package com.example.app_3k.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_3k.R;
import com.example.app_3k.activity.WebActivity;
import com.example.app_3k.adapter.FavoriteAdapter;
import com.example.app_3k.adapter.SavedAdapter;
import com.example.app_3k.base.BaseFragment;
import com.example.app_3k.dao.AppDatabase;
import com.example.app_3k.models.News;

import java.util.ArrayList;

public class FavoriteFragment extends BaseFragment implements FavoriteAdapter.FavoriteItemListener {

    private RecyclerView lvSaved;
    private FavoriteAdapter adapter;
    private ArrayList<News> data = new ArrayList<>();
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_favorite;
    }

    @Override
    public String getTitle() {
        return "Favorite";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvSaved = findViewById(R.id.lv_favorite);
        adapter = new FavoriteAdapter(getLayoutInflater());
        adapter.setItemListener(this);
        lvSaved.setAdapter(adapter);
        getData();

    }
    public void getData() {
        data.clear();
        data.addAll(AppDatabase.getInstance(getContext()).getNewsDao().getFavorite(true));
        adapter.setData(data);
    }

    @Override
    public void onNewsItemLongClicked(int position) {
        AppDatabase.getInstance(getContext()).getNewsDao().delete(data.get(position));
        getData();

    }

    @Override
    public void onNewsItemClicked(int position) {
        Intent intent = WebActivity.getInstance(getContext(), data.get(position).getUrl());
        startActivity(intent);
    }
}
