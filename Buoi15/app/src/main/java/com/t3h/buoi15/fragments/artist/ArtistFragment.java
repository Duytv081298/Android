package com.t3h.buoi15.fragments.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.AppAdapter;
import com.t3h.buoi15.R;
import com.t3h.buoi15.data.ArtistData;
import com.t3h.buoi15.databinding.FragmentAlbumBinding;
import com.t3h.buoi15.databinding.FragmentArtistBinding;
import com.t3h.buoi15.models.Artist;

public class ArtistFragment extends FragmentBase<FragmentArtistBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist;
    }

    private AppAdapter<Artist> adapter;
    private ArtistData data;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new AppAdapter<>(getLayoutInflater(),
                R.layout.item_song_artist);
        data = new ArtistData(getContext());
        adapter.setData(data.readData());
        binding.lvArtist.setAdapter(adapter);
    }
}