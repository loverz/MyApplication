//package com.example.luoxiaozhuo.myapplication.mvvm.datasource;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Lcee;
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
//import com.example.luoxiaozhuo.myapplication.mvvm.net.ProjectApi;
//import com.example.luoxiaozhuo.myapplication.utils.RetrofitFactory;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class RemoteProjectDataSource implements ProjectDataSource {
//    private static final RemoteProjectDataSource instance = new RemoteProjectDataSource();
//
//    private RemoteProjectDataSource() {
//    }
//
//    public static RemoteProjectDataSource getInstance() {
//        return instance;
//    }
//    // Retrofit ：how to create a api link.
//    private ProjectApi projectApi = RetrofitFactory.getRetrofit().create(ProjectApi.class);
//
//
//    @Override
//    public LiveData<Lcee<Projects>> queryProjects(int page) {
//        final MutableLiveData<Lcee<Projects>> data = new MutableLiveData<>();
//        data.setValue(Lcee.loading());
//        projectApi.queryProjects(page).enqueue(new Callback<Projects>() {
//            @Override
//            public void onResponse(Call<Projects> call, Response<Projects> response) {
//                Projects ps = response.body();
//                if(null == ps) {
//                    data.setValue(Lcee.empty());
//                    return;
//                }
//                data.setValue(Lcee.content(ps));
//                ps.setPage(page);
//                // store the data to database
//                LocalProjectDataSource.getInstance().addProjects(ps);
//
//            }
//
//            @Override
//            public void onFailure(Call<Projects> call, Throwable t) {
//                t.printStackTrace();
//                data.setValue(Lcee.error(t));
//            }
//        });
//
//
//        return data;
//    }
//}
