package com.example.app_3k.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_3k.R;
import com.example.app_3k.WebActivity;
import com.example.app_3k.adapter.NewsAdapter;
import com.example.app_3k.base.BaseFragment;
import com.example.app_3k.models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment implements NewsAdapter.NewsItemListener {
    private ArrayList<News> data = new ArrayList<>();
    private RecyclerView lvNews;
    private NewsAdapter adapter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvNews = findViewById(R.id.lv_news);
        adapter = new NewsAdapter(getLayoutInflater());
        adapter.setData(data);
        adapter.setListener(this);
        lvNews.setAdapter(adapter);
    }
    public void setData(List<News> data) {
        this.data.clear();
        this.data.addAll(data);
        if (adapter != null) {
            adapter.setData(this.data);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    public String getTitle() {
        return "News";
    }

    @Override
    public void onNewsItemClicked(int position) {
        Intent intent = WebActivity.getInstance(getContext(),data.get(position).getUrl());
        startActivity(intent);
    }
    @Override
    public void onNewsItemLongClicked(int position) {

    }
}
