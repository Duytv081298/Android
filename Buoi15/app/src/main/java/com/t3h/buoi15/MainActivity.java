package com.t3h.buoi15;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.t3h.basemodule.base.ActivityBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.databinding.ActivityMainBinding;
import com.t3h.buoi15.fragments.album.AlbumFragment;
import com.t3h.buoi15.fragments.artist.ArtistFragment;
import com.t3h.buoi15.fragments.song.SongFragment;
import com.t3h.buoi15.service.MP3Service;

public class MainActivity extends ActivityBase<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener, NavigationView.OnNavigationItemSelectedListener {

    private SongFragment fmSong = new SongFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private MP3Service service;

    private DrawerLayout drawer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        doRequestPermission(
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                new RequestPermissionCallback() {
                    @Override
                    public void onGranted() {
                        Intent intent = new Intent(
                                MainActivity.this,
                                MP3Service.class
                        );
                        startService(intent);
                        bindService(intent, connection, BIND_AUTO_CREATE);
                    }

                    @Override
                    public void onDenied() {
                        finish();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
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


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) iBinder;
            service = binder.getService();
            initFragment();
            binding.nav.setOnNavigationItemSelectedListener(
                    MainActivity.this
            );
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) { }
    };

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fmSong);
        transaction.add(R.id.container, fmArtist);
        transaction.add(R.id.container, fmAlbum);
        transaction.commit();
        showFragment(fmSong);
    }
    private void showFragment(FragmentBase fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.hide(fmSong);
        transaction.hide(fmArtist);
        transaction.hide(fmAlbum);
        transaction.show(fmShow);
        transaction.commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_songs:
            case R.id.nav_music_left:
                showFragment(fmSong);
                break;
            case R.id.nav_albums:
            case R.id.nav_album_left:
                showFragment(fmAlbum);
                break;
            case R.id.nav_artists:
            case R.id.nav_artist_left:
                showFragment(fmArtist);
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
    public MP3Service getService() {
        return service;
    }

}
