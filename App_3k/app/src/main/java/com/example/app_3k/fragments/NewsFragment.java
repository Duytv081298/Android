package com.example.app_3k.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_3k.R;
import com.example.app_3k.activity.MainActivity;
import com.example.app_3k.activity.WebActivity;
import com.example.app_3k.adapter.NewsAdapter;
import com.example.app_3k.base.BaseFragment;
import com.example.app_3k.dao.AppDatabase;
import com.example.app_3k.download.DownloadAsync;
import com.example.app_3k.download.FileManager;
import com.example.app_3k.models.News;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment implements NewsAdapter.NewsItemListener {
    private ArrayList<News> data = new ArrayList<>();
    private RecyclerView lvNews;
    private NewsAdapter adapter;

    private FileManager fileManager;
    private File[] files;
    public static ArrayList<String> arrUrl = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvNews = findViewById(R.id.lv_news);
        adapter = new NewsAdapter(getLayoutInflater()) {
            @Override
            protected void decodeView(NewHolder newHolder, int position) {

            }
        };
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
        arrUrl.add("file:///"+FileManager.path);

        fileManager = new FileManager();
        files = fileManager.getFiles(fileManager.getRootPath());
        new DownloadAsync().execute(data.get(position).getUrl());

        try {
            AppDatabase.getInstance(getContext())
                    .getNewsDao().insert(data.get(position));
            MainActivity act = (MainActivity) getActivity();
            act.getFmSaved().getData();
            Toast.makeText(getContext(), "News saved", Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Toast.makeText(getContext(), "News already saved", Toast.LENGTH_LONG).show();
        }
    }
}
