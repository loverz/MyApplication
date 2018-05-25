package com.example.luoxiaozhuo.myapplication.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.luoxiaozhuo.myapplication.bean.User;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long add(User user);

    @Query("select * from user where login = :username")
    LiveData<User> queryByName(String name);
}
