package com.example.luoxiaozhuo.myapplication.mvvm.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
import com.example.luoxiaozhuo.myapplication.mvvm.dao.ProjectDao;

public class ProjectServiceImpl implements ProjectService {

    private static final ProjectServiceImpl instance = new ProjectServiceImpl();


    private ProjectDao projectsDao = ProjectDBHelper.getInstance().getDB().getProjectsDao();

    private ProjectServiceImpl() {

    }

    public static ProjectServiceImpl getInstance() {
        return instance;
    }

    @Override
    public LiveData<Long> add(final Projects projects) {
        final MutableLiveData<Long> data = new MutableLiveData<>();
        new AsyncTask<Void,Void,Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                return projectsDao.add(projects);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                data.setValue(aLong);
            }
        }.execute();

        return data;
    }

    @Override
    public LiveData<Projects> queryProjects(int page) {
        return projectsDao.queryProjects(page);
    }
}
