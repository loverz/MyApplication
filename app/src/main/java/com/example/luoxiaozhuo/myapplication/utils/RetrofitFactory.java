package com.example.luoxiaozhuo.myapplication.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static OkHttpClient client;

    private static Retrofit retrofit;

    private static final String HOST = "https://api.github.com";

    static {
        client = new OkHttpClient.Builder().connectTimeout(9, TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder().baseUrl(HOST).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
