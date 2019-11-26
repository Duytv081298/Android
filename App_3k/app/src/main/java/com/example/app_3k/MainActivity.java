package com.example.app_3k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.app_3k.adapter.NewPagerAdapter;
import com.example.app_3k.api.ApiBuilder;
import com.example.app_3k.dao.AppDatabase;
import com.example.app_3k.fragments.FavoriteFragment;
import com.example.app_3k.fragments.NewsFragment;
import com.example.app_3k.fragments.SavedFragment;
import com.example.app_3k.models.News;
import com.example.app_3k.models.NewsResponse;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Callback<NewsResponse> {

    private ViewPager pager;
    private TabLayout tab;
    private NewPagerAdapter adapter;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSaved = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        adapter = new NewPagerAdapter(
                getSupportFragmentManager(),
                fmNews,fmSaved,fmFavorite
        );
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        //TODO

        List<News> data = AppDatabase.getInstance(this)
                .getNewsDao().getNews();
        fmNews.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        SearchView search = (SearchView) menu.findItem(R.id.memu_search)
                .getActionView();
        search.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        pager.setCurrentItem(0);
        ApiBuilder.getInstance().searchNews(
                query,
                "f70e06a71e524dfa86dbfcf7ca38e62f",
                "vi"
        ).enqueue(this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        NewsResponse newsResponse = response.body();
        ArrayList<News> data = newsResponse.getArticles();
        fmNews.setData(data);
        News[] news = new News[data.size()];
        data.toArray(news);
        AppDatabase.getInstance(this).getNewsDao().update(news);
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Toast.makeText(this,
                t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
