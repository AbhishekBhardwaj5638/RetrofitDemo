package com.bhardwaj.abhishek.retrofitdemo;

import com.bhardwaj.abhishek.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("todos")
     Call<List<UserInfo>> getUserInfo();
}
