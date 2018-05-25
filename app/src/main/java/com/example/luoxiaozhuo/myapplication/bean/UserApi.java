package com.example.luoxiaozhuo.myapplication.bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/users/{username}")
    Call<User> queryUserByUserName(@Path("username") String username);
}
