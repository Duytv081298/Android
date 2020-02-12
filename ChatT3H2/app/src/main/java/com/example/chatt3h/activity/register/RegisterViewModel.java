package com.example.chatt3h.activity.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.chatt3h.api.ApiBuider;
import com.example.chatt3h.model.Event;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends AndroidViewModel {
    private MutableLiveData<Event> event = new MutableLiveData<>();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void register(String email, String name, String password) {
        event.postValue(new Event(false, true, false));
        ApiBuider.getInstance().register(email, password, name).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    event.postValue(new Event(false, true, false));
                } else {
                    event.postValue(new Event(false, false, true));
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                event.postValue(new Event(false, false, true));
            }
        });
    }
}
