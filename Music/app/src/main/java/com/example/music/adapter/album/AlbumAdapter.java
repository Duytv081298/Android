package com.example.music.adapter.album;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.databinding.ItemSongAlbumBinding;
import com.example.music.models.Album;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {
    private ArrayList<Album> data;
    private LayoutInflater inflater;
    private AlbumListener listener;

    public AlbumAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Album> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(AlbumListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongAlbumBinding binding = ItemSongAlbumBinding.inflate(
                inflater, parent, false
        );
        return new AlbumHolder(binding);
    }



        @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {
        holder.binding.setItemalbum(data.get(position));

        if (listener !=null){
            holder.binding.setAlbumlistener(listener);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class AlbumHolder extends RecyclerView.ViewHolder {

        private ItemSongAlbumBinding binding;

        public AlbumHolder(@NonNull ItemSongAlbumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
