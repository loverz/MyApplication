package com.example.luoxiaozhuo.myapplication.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import  android.arch.lifecycle.ViewModel;

import com.example.luoxiaozhuo.myapplication.bean.UserBean;
import com.kelin.mvvmlight.command.ReplyCommand;

public class MyViewModel extends ViewModel {
    // 可以在此处增加子ModelView的关键代码


    public final ReplyCommand onMoreCommand = new ReplyCommand(()->{

    });


    private MutableLiveData<UserBean> user;

    public LiveData<UserBean> getUser(){
        if(user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void setUser(String name,int id){
        user.setValue(new UserBean(name,id));
    }

}
