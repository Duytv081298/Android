package com.example.buoi11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

import com.example.buoi11.utils.PermissionUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private FileManager manager;
    private File[] files;

    private final String[] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (PermissionUtils.checkPermission(this, PERMISSIONS)){
            initViews();
        }else {
            PermissionUtils.requestPermission(this,PERMISSIONS,0);
        }
    }

    private void initViews() {
        manager = new FileManager();
        files = manager.getFiles(manager.getRootPath());

        String link = "https://www.24h.com.vn/lionel-messi-c48e4386.html";
        new DownloadAsync().execute(link);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result = PermissionUtils.checkPermission(this,permissions);
        if(result){
            initViews();
        }else {
            finish();
        }
    }
}
