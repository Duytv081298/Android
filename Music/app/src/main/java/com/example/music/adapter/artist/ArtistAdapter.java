package com.example.music.adapter.artist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.databinding.ItemSongArtistBinding;
import com.example.music.models.Song;

import java.util.ArrayList;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistHolder> {
    private ArrayList<Song> data;
    private LayoutInflater inflater;
    private ArtistListener listener;

    public ArtistAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(ArtistListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArtistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongArtistBinding binding = ItemSongArtistBinding.inflate(
                inflater, parent, false
        );
        return new ArtistHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull ArtistHolder holder, int position) {
        holder.binding.setItem(data.get(position));

        if (listener !=null){
            holder.binding.setArtistlistener(listener);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ArtistHolder extends RecyclerView.ViewHolder {

        private ItemSongArtistBinding binding;

        public ArtistHolder(@NonNull ItemSongArtistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
