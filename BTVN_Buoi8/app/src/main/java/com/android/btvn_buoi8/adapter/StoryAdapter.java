package com.android.btvn_buoi8.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.btvn_buoi8.Models.Story;
import com.android.btvn_buoi8.R;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private ArrayList<Story> listStory;
    private LayoutInflater inflater;
    private StoryListener listener;

    public StoryAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setListStory(ArrayList<Story> listStory) {
        this.listStory = listStory;
        notifyDataSetChanged();

    }

    public void setListener(StoryListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_story, //id layut
                parent, //Nhóm layout
                false);
        return new StoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, final int position) {
        Story story = listStory.get(position);
        holder.bindData(story);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onStoryItemClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onStoryItemLongClick(position);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listener == null ? 0 : listStory.size();
    }

    public class StoryHolder extends RecyclerView.ViewHolder {

        private ImageView profile_image;
        private TextView ten;
        private TextView chuong;
        private TextView tacgia;
        private TextView ncn;


        public StoryHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            ten = itemView.findViewById(R.id.ten);
            chuong = itemView.findViewById(R.id.chuong);
            tacgia = itemView.findViewById(R.id.tacgia);
            ncn = itemView.findViewById(R.id.ncn);
        }

        public void bindData(Story item) {
            profile_image.setImageResource(item.getIcon());
            ten.setText(item.getTen());
            chuong.setText(item.getChuong());
            tacgia.setText(item.getTacgia());
            ncn.setText(item.getNcn());
        }
    }
    public interface StoryListener {
        void onStoryItemClick(int position);
        void onStoryItemLongClick(int position);
    }
}
