package com.android.buoi10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.buoi10.adapter.NewsAdapter;
import com.android.buoi10.api.ApiBuilder;
import com.android.buoi10.model.NewResponse;
import com.android.buoi10.model.News;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewResponse> {
    private Button btnSearch;
    private EditText edtSearch;
    private NewsAdapter adapter;
    public ArrayList<News> news = new ArrayList<>();
    private RecyclerView recyclerNew;

    private String text;


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return false;
            }
        });
        return true;
    }


    private void initView() {
        btnSearch = findViewById(R.id.btn_search);
        edtSearch = findViewById(R.id.edt_search);
        btnSearch.setOnClickListener( this);


        recyclerNew = findViewById(R.id.lv_face);
        adapter = new NewsAdapter(getLayoutInflater());
        recyclerNew.setAdapter(adapter);

        toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        String q = edtSearch.getText().toString();
        ApiBuilder.getInstance().searchNews(text,"9fbefe6e60214d31921c57b56fe53f29", "vi").enqueue(this);
    }

    private void search(String query){
        ApiBuilder.getInstance().searchNews(query,"9fbefe6e60214d31921c57b56fe53f29", "vi").enqueue(this);
    }

    @Override
    public void onResponse(Call<NewResponse> call, Response<NewResponse> response) {
        NewResponse newResponse = response.body();
        adapter.setData(newResponse.getArticles());

    }

    @Override
    public void onFailure(Call<NewResponse> call, Throwable t) {
        Toast.makeText(this, t.getMessage(),Toast.LENGTH_SHORT).show();
    }


}
