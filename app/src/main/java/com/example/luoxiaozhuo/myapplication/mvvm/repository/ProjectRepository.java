package com.example.luoxiaozhuo.myapplication.mvvm.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.luoxiaozhuo.myapplication.mvvm.bean.Lcee;
import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
import com.example.luoxiaozhuo.myapplication.mvvm.datasource.LocalProjectDataSource;
import com.example.luoxiaozhuo.myapplication.mvvm.datasource.ProjectDataSource;
import com.example.luoxiaozhuo.myapplication.mvvm.datasource.RemoteProjectDataSource;
import com.example.luoxiaozhuo.myapplication.mvvm.util.NetworkUtils;

public class ProjectRepository {

    private static final ProjectRepository instance = new ProjectRepository();

    private ProjectRepository() {
    }
    public static ProjectRepository getInstance() {
        return instance;
    }

    private Context context;

    private ProjectDataSource remoteDS = RemoteProjectDataSource.getInstance();

    private ProjectDataSource localDS = LocalProjectDataSource.getInstance();

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public LiveData<Lcee<Projects>> getProjects(int page) {
        if (NetworkUtils.isConnected(context)) {
            return remoteDS.queryProjects(page);
        } else {
            return localDS.queryProjects(page);
        }
    }


}
