package com.example.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.music.R;
import com.example.music.adapter.album.AlbumAdapter;
import com.example.music.adapter.album.AlbumListener;
import com.example.music.adapter.artist.ArtistAdapter;
import com.example.music.base.BaseFragment;
import com.example.music.data.AlbumData;
import com.example.music.data.ArtistData;
import com.example.music.databinding.FragmentArtistBinding;
import com.example.music.models.Album;
import com.example.music.models.Artist;

import java.util.ArrayList;

public class AlbumFragment extends BaseFragment implements AlbumListener {
    private AlbumData data;
    private ArrayList<Album> arr;
    private AlbumAdapter adapter;
    private FragmentArtistBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist, container, false);
        data = new AlbumData(getContext());
        arr = data.readData();

        arr.size();
        adapter = new AlbumAdapter(getLayoutInflater());

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
        return R.layout.fragment_album;
    }

    @Override
    public String getTitle() {
        return "Album";
    }


    @Override
    public void onItemAlbumClicked(Album album) {

    }
}
