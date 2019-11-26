package com.example.test_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.example.test_app.adapter.NewsAdapter;
import com.example.test_app.api.ApiBuilder;
import com.example.test_app.fragment.Favourite;
import com.example.test_app.fragment.Newtt;
import com.example.test_app.fragment.Saved;
import com.example.test_app.models.News;
import com.example.test_app.models.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<NewsResponse> {

    private NewsAdapter adapter;
//    private RecyclerView recyclerNew;

    private Toolbar toolbar;

    private Newtt newtt = new Newtt();
    private Favourite favourite = new Favourite();
    private Saved saved = new Saved();


    public NewsAdapter getAdapter() {
        return adapter;
    }

    public Newtt getNewtt() {
        return newtt;
    }

    public Favourite getFavourite() {
        return favourite;
    }

    public Saved getSaved() {
        return saved;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        adapter = new NewsAdapter(getLayoutInflater());

//        recyclerNew = findViewById(R.id.lv_new);
//        recyclerNew.setAdapter(adapter);

        toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);

        initFragment();
        showFragment(newtt);
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,newtt);
        transaction.add(R.id.container,saved);
        transaction.add(R.id.container,favourite);
        transaction.commit();
    }

    public void showFragment(Fragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(newtt);
        transaction.hide(saved);
        transaction.hide(favourite);
        transaction.show(fmShow);
        transaction.commit();
    }

    private void search(String query) {
        ApiBuilder.getInstance().searchNews(
                query,
                "f70e06a71e524dfa86dbfcf7ca38e62f",
                "vi"
        ).enqueue(this);
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        NewsResponse newsResponse = response.body();
        adapter.setData(newsResponse.getArticles());
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Toast.makeText(this,
                t.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }


}
