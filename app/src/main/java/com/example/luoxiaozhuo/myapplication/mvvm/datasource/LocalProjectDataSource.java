//package com.example.luoxiaozhuo.myapplication.mvvm.datasource;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MediatorLiveData;
//
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Lcee;
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
//import com.example.luoxiaozhuo.myapplication.mvvm.db.ProjectService;
//import com.example.luoxiaozhuo.myapplication.mvvm.db.ProjectServiceImpl;
//
//public class LocalProjectDataSource implements ProjectDataSource {
//
//    private static LocalProjectDataSource instance = new LocalProjectDataSource();
//
//    public static LocalProjectDataSource getInstance() {
//        return instance;
//    }
//
//    ProjectService service = ProjectServiceImpl.getInstance();
//
//    public LiveData<Long> addProjects(Projects projects) {
//
//        projects.itemsToJson();
//
//        return service.add(projects);
//    }
//
//
//    @Override
//    public LiveData<Lcee<Projects>> queryProjects(int page) {
//        final MediatorLiveData<Lcee<Projects>> data = new MediatorLiveData<>();
//        data.setValue(Lcee.loading());
//
//        data.addSource(service.queryProjects(page), (projects) -> {
//
//            if (null == projects) {
//                data.setValue(Lcee.empty());
//            } else {
//                // parse items from json
//                projects.itemsFromJson();
//                data.setValue(Lcee.content(projects));
//            }
//
//        });
//
//
//        return data;
//    }
//}
