package com.example.app_3k.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_3k.R;
import com.example.app_3k.models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewHolder>{
    private ArrayList<News> data;
    private LayoutInflater inflater;
    private NewsItemListener listener;

    public NewsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(NewsItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_new,
                parent,
                false);
        return new NewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewHolder holder, int position) {
        News news = data.get(position);
        holder.bindData(news);
    }
    
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder {

        private ImageView imgNew;
        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPublishedAt;


        public NewHolder(@NonNull View itemView) {
            super(itemView);
            imgNew = itemView.findViewById(R.id.img_new);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPublishedAt = itemView.findViewById(R.id.tv_publishedAt);
        }
        public void bindData(News item) {
            loadImage(imgNew, item.getUrlToImage());
            tvTitle.setText(item.getTitle());
            tvDescription.setText(item.getDescription());
            tvPublishedAt.setText(item.getPublishedAt());
        }
    }
    private void loadImage(ImageView im, String link){
        Glide.with(im)
                .load(link)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(im);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.bindData(data.get(position));
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNewsItemClicked(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onNewsItemLongClicked(position);
                    return true;
                }
            });
        }
    }

    public interface NewsItemListener{
        void onNewsItemClicked(int position);
        void onNewsItemLongClicked(int position);
    }

}
