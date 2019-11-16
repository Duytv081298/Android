package com.android.buoi10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.buoi10.R;
import com.android.buoi10.model.News;

import java.util.ArrayList;

public class NewsAdapter {
    private ArrayList<News> data;
    private LayoutInflater inflater;
    private NewsItemListener listener;

    public class NewHolder extends RecyclerView.ViewHolder { // giữ tất cả những ánh xạ item view

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
        public void bindData(News item) {    // Đổ dữ liệu lên view
            tvTitle.setText(item.getTitle());
            tvDescription.setText(item.getDescription());
            tvPublishedAt.setText(item.getPublishedAt());
        }
    }
    public interface NewsItemListener {
        void onNewsItemClick(int position);

        void onNewsItemLongClick(int position);
    }
}
