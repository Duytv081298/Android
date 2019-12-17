package com.example.app_3k.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_3k.R;
import com.example.app_3k.activity.MainActivity;
import com.example.app_3k.activity.WebActivity;
import com.example.app_3k.adapter.NewsAdapter;
import com.example.app_3k.adapter.SavedAdapter;
import com.example.app_3k.base.BaseFragment;
import com.example.app_3k.dao.AppDatabase;
import com.example.app_3k.models.News;

import java.util.ArrayList;

public class SavedFragment extends BaseFragment implements SavedAdapter.SavedItemListener {

    private RecyclerView lvSaved;
    private SavedAdapter adapter;
    private ArrayList<News> data = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_saved;
    }

    @Override
    public String getTitle() {
        return "Saved";
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvSaved = findViewById(R.id.lv_saved);
        adapter = new SavedAdapter(getLayoutInflater());
        adapter.setItemListener(this);
        lvSaved.setAdapter(adapter);
        getData();
    }

    public void getData() {
        data.clear();
        data.addAll(AppDatabase.getInstance(getContext()).getNewsDao().getNews());
        adapter.setData(data);
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = WebActivity.getInstance(getContext(),NewsFragment.arrUrl.get(position));
        startActivity(intent);
    }

    @Override
    public void deleteItemClicked(int position) {
        AppDatabase.getInstance(getContext()).getNewsDao().delete(data.get(position));
        getData();
    }

    @Override
    public void favoriteItemClicked(int position) {
        News news = data.get(position);
        news.setFavorite(true);
        AppDatabase.getInstance(getContext()).getNewsDao().update(news);
        MainActivity act = (MainActivity) getActivity();
        act.getFmFavorite().getData();
    }
}
