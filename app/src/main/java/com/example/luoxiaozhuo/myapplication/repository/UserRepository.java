//package com.example.luoxiaozhuo.myapplication.repository;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//
//import com.example.luoxiaozhuo.myapplication.bean.User;
//import com.example.luoxiaozhuo.myapplication.bean.UserApi;
//import com.example.luoxiaozhuo.myapplication.utils.RetrofitFactory;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class UserRepository {
//
//    private static UserRepository instance;
//
//    public static UserRepository getInstance(){
//        if(instance == null) {
//            instance = new UserRepository();
//        }
//        return instance;
//    }
//
//    private UserApi userApi = RetrofitFactory.getRetrofit().create(UserApi.class);
//
//    // 这里执行数据请求
//    public LiveData<User> getUser(String username) {
//
//        final MutableLiveData<User> user = new MutableLiveData<>();
//
//        userApi.queryUserByUserName(username).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                user.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//
//
//        return user;
//    }
//}
