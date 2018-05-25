package com.example.luoxiaozhuo.myapplication.dao;

import android.arch.lifecycle.LiveData;

import com.example.luoxiaozhuo.myapplication.bean.User;

public interface UserService {
    LiveData<Long> add(User user);

    LiveData<User> queryByName(String name);
}
