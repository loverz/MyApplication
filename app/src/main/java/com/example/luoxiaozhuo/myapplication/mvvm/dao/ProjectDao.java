//package com.example.luoxiaozhuo.myapplication.mvvm.dao;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
//
//@Dao
//
//public interface ProjectDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    Long add(Projects projects);
//
//    @Query("select * from projects where page=:page")
//    LiveData<Projects> queryProjects(int page);
//}
