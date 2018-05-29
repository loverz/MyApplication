package com.example.luoxiaozhuo.myapplication.mvvm.net;


import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProjectApi {
    @GET("/search/repositories?q=tetris+language:assembly&sort=stars&order=desc")
    Call<Projects> queryProjects(@Query("page") int page);

}
