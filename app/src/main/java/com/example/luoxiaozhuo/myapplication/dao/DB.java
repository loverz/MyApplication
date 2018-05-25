package com.example.luoxiaozhuo.myapplication.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.luoxiaozhuo.myapplication.bean.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class DB extends RoomDatabase {
    public abstract UserDao getUserDao();
}
