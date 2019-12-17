package com.example.app_3k.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.PopupMenu;

import com.example.app_3k.R;

public class SavedAdapter extends NewsAdapter{

    private SavedItemListener itemListener;

    public SavedAdapter(LayoutInflater inflater) {
        super(inflater);
    }


    public void setItemListener(SavedItemListener itemListener) {
        this.itemListener = itemListener;
    }



    @Override
    protected void decodeView(NewHolder newHolder, int position) {

        newHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.itemClicked(position);
            }
        });
        newHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu menu = new PopupMenu(
                        newHolder.itemView.getContext(),
                        newHolder.itemView
                );
                menu.inflate(R.menu.save);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_delete:
                                itemListener.deleteItemClicked(position);
                                break;
                            case R.id.menu_favorite:
                                itemListener.favoriteItemClicked(position);
                                break;
                        }
                        return true;
                    }
                });
                menu.show();
                return true;
            }
        });

    }

    public interface SavedItemListener {
        void itemClicked(int position);
        void deleteItemClicked(int position);
        void favoriteItemClicked(int position);
    }
}
