package com.example.music.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.example.music.R;
import com.example.music.adapter.NewMusicAdapter;
import com.example.music.fragment.AlbumFragment;
import com.example.music.fragment.ArtistFragment;
import com.example.music.fragment.MusicFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    private ViewPager pager;
    private TabLayout tab;
    private NewMusicAdapter adapter;

    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private MusicFragment fmMusic = new MusicFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        adapter = new NewMusicAdapter(
                getSupportFragmentManager(),
                fmMusic, fmAlbum,fmArtist
        );
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
