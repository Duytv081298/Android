package com.example.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.music.R;
import com.example.music.adapter.SongAdapter;
import com.example.music.adapter.SongListener;
import com.example.music.base.BaseFragment;
import com.example.music.data.SystemData;

import com.example.music.databinding.FragmentArtistBinding;
import com.example.music.models.Song;

import java.util.ArrayList;

public class ArtistFragment extends BaseFragment implements SongListener {
    private SystemData data;
    private ArrayList<Song> arr;
    private SongAdapter adapter;
    private FragmentArtistBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist, container, false);
        data = new SystemData(getContext());

        arr = data.readData();

        arr.size();
        adapter = new SongAdapter(getLayoutInflater());

        adapter.setData(arr);
        adapter.setListener(this);
        binding.lvSongArtist.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_artist;
    }

    @Override
    public String getTitle() {
        return "Artist";
    }

    @Override
    public void onItemSongClicked(Song song) {

    }
}
