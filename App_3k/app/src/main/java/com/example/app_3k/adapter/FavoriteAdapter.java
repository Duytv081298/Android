package com.example.app_3k.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;

public class FavoriteAdapter extends NewsAdapter{

    private FavoriteItemListener itemListener;

    public FavoriteAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    public void setItemListener(FavoriteItemListener itemListener) {
        this.itemListener = itemListener;
    }


    @Override
    protected void decodeView(NewHolder newHolder, int position) {
        newHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onNewsItemClicked(position);
            }
        });
        newHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemListener.onNewsItemLongClicked(position);
                return true;
            }
        });

    }

    public interface FavoriteItemListener {
        void onNewsItemLongClicked(int position);

        void onNewsItemClicked(int position);
    }
}
