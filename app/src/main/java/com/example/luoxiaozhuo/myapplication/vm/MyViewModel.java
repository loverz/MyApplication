package com.example.luoxiaozhuo.myapplication.vm;

import  android.arch.lifecycle.ViewModel;

import com.kelin.mvvmlight.command.ReplyCommand;

public class MyViewModel extends ViewModel {
    // 可以在此处增加子ModelView的关键代码


    public final ReplyCommand onMoreCommand = new ReplyCommand(()->{
        new Thread (() ->{

        }).start();
    });


}
