package com.dpridoy.mvvmrecyclerviewapp.utils;

import com.dpridoy.mvvmrecyclerviewapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("users")
    Call<List<User>> getUsers();
}
