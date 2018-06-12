//package com.example.luoxiaozhuo.myapplication.mvvm.vm;
//
//import android.arch.core.util.Function;
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//import android.arch.lifecycle.Transformations;
//import android.arch.lifecycle.ViewModel;
//
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Lcee;
//import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
//import com.example.luoxiaozhuo.myapplication.mvvm.repository.ProjectRepository;
//import com.example.luoxiaozhuo.myapplication.mvvm.util.PageUtils;
//
//public class ProjectViewModel extends ViewModel {
//    private ProjectRepository projectRepository = ProjectRepository.getInstance();
//
//    private MutableLiveData<Integer> ldPage;;
//    private LiveData<Lcee<Projects>> ldProjects;
//
//    public LiveData<Lcee<Projects>> getProjects() {
//        if (null == ldProjects) {
//            ldPage = new MutableLiveData<>();
////            ldProjects = Transformations.switchMap(ldPage, new Function<Integer, LiveData<Lcee<Projects>>>() {
////                @Override
////                public LiveData<Lcee<Projects>> apply(Integer page) {
////                    return projectRepository.getProjects(page);
////                }
////            });
//            ldProjects = Transformations.switchMap(ldPage,(page)-> projectRepository.getProjects(page));
//        }
//        return ldProjects;
//    }
//
//    public void reload() {
//        ldPage.setValue(1);
//    }
//
//    public void loadMore(int currentCount) {
//        ldPage.setValue(PageUtils.getPage(currentCount));
//    }
//
//}
