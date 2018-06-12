//package com.example.luoxiaozhuo.myapplication.mvvm.db;
//
//import android.arch.persistence.room.Room;
//import android.content.Context;
//
//public class ProjectDBHelper {
//    private static final ProjectDBHelper instance = new ProjectDBHelper();
//
//    private static final String DATABASE_NAME = "f_load_more";
//
//    public static ProjectDBHelper getInstance() {
//        return instance;
//
//    }
//
//    private ProjectDB db;
//
//    public void init(Context context) {
//        db = Room.databaseBuilder(context.getApplicationContext(), ProjectDB.class, DATABASE_NAME).build();
//
//    }
//
//    public ProjectDB getDB() {
//        return db;
//    }
//}
