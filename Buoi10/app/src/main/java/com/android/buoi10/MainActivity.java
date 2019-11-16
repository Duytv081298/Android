package com.android.buoi10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.buoi10.api.ApiBuilder;
import com.android.buoi10.model.NewResponse;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewResponse> {
    private Button btnSearch;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnSearch = findViewById(R.id.btn_search);
        edtSearch = findViewById(R.id.edt_search);
        btnSearch.setOnClickListener( this);
    }

    @Override
    public void onClick(View v) {
        String q = edtSearch.getText().toString();
        ApiBuilder.getInstance().searchNews(q,"9fbefe6e60214d31921c57b56fe53f29", "vi").enqueue(this);
    }

    @Override
    public void onResponse(Call<NewResponse> call, Response<NewResponse> response) {
        NewResponse newResponse = response.body();
        int a=3;
    }

    @Override
    public void onFailure(Call<NewResponse> call, Throwable t) {
        Toast.makeText(this, t.getMessage(),Toast.LENGTH_SHORT).show();

    }

    private void loadImage(ImageView im, String link){
        Glide.with(im)
                .load(link)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(im);
    }
}
