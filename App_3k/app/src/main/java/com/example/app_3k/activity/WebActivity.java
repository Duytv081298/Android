package com.example.app_3k.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_3k.R;

public class WebActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "extra_url";

    private Dialog dialog;
    private WebView webView;
    
    public static Intent getInstance(Context context, String url){
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(EXTRA_URL, url);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initViews();
    }

    private void initViews() {
        String url = getIntent().getStringExtra(EXTRA_URL);
        dialog = new Dialog(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_progress);
        dialog.setCancelable(false);
        dialog.show();
        webView = findViewById(R.id.web_view);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();
            }
        });
    }
}
