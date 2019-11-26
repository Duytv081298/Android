package com.example.test_app_3k;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.test_app_3k.adapter.NewsAdapter;
import com.example.test_app_3k.adapter.ViewsAdapter;
import com.example.test_app_3k.api.ApiBuilder;
import com.example.test_app_3k.fragment.Favourite;
import com.example.test_app_3k.fragment.Newtt;
import com.example.test_app_3k.fragment.Saved;
import com.example.test_app_3k.model.NewResponse;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<NewResponse> {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewsAdapter viewsAdapteradapter;
    private NewsAdapter adapter;
    private Toolbar toolbar;

    private Newtt newtt;
    private Saved saved;
    private Favourite favourite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        viewsAdapteradapter = new ViewsAdapter(getSupportFragmentManager());

        newtt = new Newtt();
        saved = new Saved();
        favourite = new Favourite();

        viewsAdapteradapter.AddFragment(newtt, "News");
        viewsAdapteradapter.AddFragment(saved, "Saved");
        viewsAdapteradapter.AddFragment(favourite, "Favourite");

        viewPager.setAdapter(viewsAdapteradapter);
        tabLayout.setupWithViewPager(viewPager);

        toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
    }

    @SuppressLint("ResourceType")
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
//                search(newText);
                return false;
            }
        });
        return true;
    }

    private void search(String query) {
        ApiBuilder.getInstance().searchNews(query, "9fbefe6e60214d31921c57b56fe53f29", "vi").enqueue(this);
    }

    @Override
    public void onResponse(Call<NewResponse> call, Response<NewResponse> response) {
        NewResponse newResponse = response.body();
        adapter.setData(newResponse.getArticles());
        System.out.println("3");
    }

    @Override
    public void onFailure(Call<NewResponse> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
