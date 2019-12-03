package com.example.buoi11;

import android.os.AsyncTask;

public class DownloadAsync extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        FileManager manager = new FileManager();
        return  manager.downlod(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
