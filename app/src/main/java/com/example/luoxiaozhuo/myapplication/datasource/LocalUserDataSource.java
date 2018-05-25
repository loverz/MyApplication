package com.example.luoxiaozhuo.myapplication.datasource;

import android.arch.lifecycle.LiveData;

import com.example.luoxiaozhuo.myapplication.bean.User;
import com.example.luoxiaozhuo.myapplication.dao.UserServersImpl;
import com.example.luoxiaozhuo.myapplication.dao.UserService;

public class LocalUserDataSource implements UserDataSource {
    private static final LocalUserDataSource instance = new LocalUserDataSource();
    private LocalUserDataSource() {
    }
    public static LocalUserDataSource getInstance() {
        return instance;
    }


    private UserService userService = UserServersImpl.instance;

    @Override
    public LiveData<User> queryByName(String username) {
        return userService.queryByName(username);
    }

    public LiveData<Long> addUser(User user) {
        return userService.add(user);
    }
}
