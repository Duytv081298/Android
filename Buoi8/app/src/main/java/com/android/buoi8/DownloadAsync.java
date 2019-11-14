package com.android.buoi8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadAsync  extends AsyncTask<String, Integer, Bitmap> {

    private DownloadFileCallBack callBack;

    public DownloadAsync(DownloadFileCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void onPreExecute() { // được gọi vào đầu tiên chuẩn bị dữ liệu cần thiết
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {  // cập nhật lại giao diện
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {  // Trả về
        super.onPostExecute(bitmap);
        callBack.onDonloadResult(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) { // thực hiện cv cần thiết tương tự run
        String link = strings[0];
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            return BitmapFactory.decodeStream(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface DownloadFileCallBack{
        void onDonloadResult(Bitmap bitmap);
    }


}
