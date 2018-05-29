package com.example.luoxiaozhuo.myapplication.mvvm.db;

import android.arch.lifecycle.LiveData;

import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;

public interface ProjectService {

    LiveData<Long> add(Projects projects);


    LiveData<Projects> queryProjects(int page);

}
