package com.dpridoy.mvvmrecyclerviewapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.dpridoy.mvvmrecyclerviewapp.utils.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    Application application;
    List<User> users;
    MutableLiveData<List<User>> mutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<User>> getUserData(){
        if (mutableLiveData==null){
            mutableLiveData= new MutableLiveData<>();
        }

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);

        Call<List<User>> call=api.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                users=response.body();
                mutableLiveData.setValue(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
