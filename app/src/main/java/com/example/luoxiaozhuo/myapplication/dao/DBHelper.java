//package com.example.luoxiaozhuo.myapplication.dao;
//
//import android.arch.persistence.room.Room;
//import android.content.Context;
//
//public class DBHelper {
//    private static final DBHelper instance = new DBHelper();
//
//    private static final String DB_NAME = "mydb";
//
//    public static DBHelper getInstance(){
//        return instance;
//    }
//
//    private DB db;
//
//    public void init(Context context) {
//        db = Room.databaseBuilder(context.getApplicationContext(),DB.class,DB_NAME).build();
//    }
//
//    public DB getDb(){
//        return db;
//    }
//}
