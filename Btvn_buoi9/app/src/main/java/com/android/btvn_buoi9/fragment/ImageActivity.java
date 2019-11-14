package com.android.btvn_buoi9.fragment;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.btvn_buoi9.R;

import static android.app.Activity.RESULT_OK;
import static com.android.btvn_buoi9.fragment.HomeActivity.REQUEST_IMAGE;

public class ImageActivity extends Fragment {
    private final String TAG = "ImageActivity";
    private ImageView imGallery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.activity_image , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        imGallery = getActivity().findViewById(R.id.im_gallery);
    }
    public ImageView getImGallery() {
        return imGallery;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
