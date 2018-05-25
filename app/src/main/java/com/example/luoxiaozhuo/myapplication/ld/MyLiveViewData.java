package com.example.luoxiaozhuo.myapplication.ld;

import java.util.ArrayList;
import java.util.List;

/**
 * 模式实现MVVM中观察者模式
 *
 */
public class MyLiveViewData<T> {
    List<OnValueChangeListener<T>> obs = new ArrayList<>();

    public void observer(OnValueChangeListener<T> observer){
        obs.add(observer);
    }

    public void unObserver(OnValueChangeListener<T> observer){
        obs.remove(observer);
    }

    public void setValue(T value){
        for (OnValueChangeListener listener :
                obs) {
            listener.valueChange(value);
        }
    }
}
