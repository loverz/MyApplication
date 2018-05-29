package com.example.luoxiaozhuo.myapplication.mvvm.bean;

public class Lcee<T> {
    public final Status status;

    public final T data;

    public final Throwable error;

    private Lcee(Status status,T data,Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> Lcee<T> content(T data) {
        return new Lcee<>(Status.Content, data, null);
    }

    public static <T> Lcee<T> error(T data, Throwable error) {
        return new Lcee<>(Status.Error, data, error);
    }
    public static <T> Lcee<T> error(Throwable error) {
        return error(null, error);
    }

    public static <T> Lcee<T> empty(T data) {
        return new Lcee<>(Status.Empty, data, null);
    }
    public static <T> Lcee<T> empty() {
        return empty(null);
    }

    public static <T> Lcee<T> loading(T data) {
        return new Lcee<>(Status.Loading, data, null);
    }
    public static <T> Lcee<T> loading() {
        return loading(null);
    }

}
