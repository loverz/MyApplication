package com.example.luoxiaozhuo.myapplication.datasource;

import android.arch.lifecycle.LiveData;

import com.example.luoxiaozhuo.myapplication.bean.User;

public class RemoteUserDataSource implements UserDataSource {

    @Override
    public LiveData<User> queryByName(String name) {
        return null;
    }
}
