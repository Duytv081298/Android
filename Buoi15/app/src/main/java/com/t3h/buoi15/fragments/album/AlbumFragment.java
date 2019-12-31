package com.t3h.buoi15.fragments.album;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.AppAdapter;
import com.t3h.buoi15.R;
import com.t3h.buoi15.data.AlbumData;
import com.t3h.buoi15.databinding.FragmentAlbumBinding;
import com.t3h.buoi15.databinding.FragmentSongBinding;
import com.t3h.buoi15.models.Album;

public class AlbumFragment extends FragmentBase<FragmentAlbumBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album;
    }

    private AppAdapter<Album> adapter;
    private AlbumData data;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new AppAdapter<>(getLayoutInflater(),
                R.layout.item_song_album);
        data = new AlbumData(getContext());
        adapter.setData(data.readData());
        binding.lvAlbum.setAdapter(adapter);
    }
}
