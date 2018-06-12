//package com.example.luoxiaozhuo.myapplication.mvvm.bean;
//
//import android.arch.persistence.room.ColumnInfo;
//import android.arch.persistence.room.Entity;
//import android.arch.persistence.room.Ignore;
//import android.arch.persistence.room.PrimaryKey;
//import android.text.TextUtils;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.Serializable;
//import java.util.Collections;
//import java.util.List;
//@Entity(tableName = "projects")
//public class Projects implements Serializable {
//
//    private int total_count;
//    private boolean incomplete_results;
//    @Ignore
//    private List<ProjectItem> items;
//    @PrimaryKey
//    private int page;
//    @ColumnInfo(name = "items")
//    private String itemsJson;
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public void setItemsJson(String itemsJson) {
//        this.itemsJson = itemsJson;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public String getItemsJson() {
//        return itemsJson;
//    }
//
//    public void setTotal_count(int total_count) {
//        this.total_count = total_count;
//    }
//
//    public void setIncomplete_results(boolean incomplete_results) {
//        this.incomplete_results = incomplete_results;
//    }
//
//    public void setItems(List<ProjectItem> items) {
//        this.items = items;
//    }
//
//    public int getTotal_count() {
//        return total_count;
//    }
//
//    public boolean isIncomplete_results() {
//        return incomplete_results;
//    }
//
//    public List<ProjectItem> getItems() {
//        return items;
//    }
//
//    public void itemsToJson() {
//        if (items == null)
//            items = Collections.emptyList();
//        itemsJson = new Gson().toJson(items);
//    }
//
//    public void itemsFromJson() {
//        if (TextUtils.isEmpty(itemsJson))
//            return;
//        items = new Gson().fromJson(itemsJson, new TypeToken<List<ProjectItem>>(){}.getType());
//    }
//
//}
