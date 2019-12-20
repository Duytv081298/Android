package com.example.buoi14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.buoi14.adapter.SongAdapter;
import com.example.buoi14.adapter.SongListener;
import com.example.buoi14.data.SystemData;
import com.example.buoi14.databinding.ActivityMainBinding;
import com.example.buoi14.models.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongListener {

    private SystemData data;
    private ArrayList<Song> arr;


    private SongAdapter adapter;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        data = new SystemData(this);

        arr = data.readData();


        adapter = new SongAdapter(getLayoutInflater());
        adapter.setData(arr);
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);
    }



    @Override
    public void onItemSongClicked(Song song) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
