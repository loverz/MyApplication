package com.example.luoxiaozhuo.myapplication.mvvm.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
import com.example.luoxiaozhuo.myapplication.mvvm.dao.ProjectDao;
@Database(entities = {Projects.class},version = 1,exportSchema = false)
public abstract class ProjectDB extends RoomDatabase {

    public abstract ProjectDao getProjectsDao();
}
