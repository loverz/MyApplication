package com.example.luoxiaozhuo.myapplication.fg;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.luoxiaozhuo.myapplication.R;
import com.example.luoxiaozhuo.myapplication.mvvm.adapter.ProjectsAdapter;
import com.example.luoxiaozhuo.myapplication.mvvm.bean.Lcee;
import com.example.luoxiaozhuo.myapplication.mvvm.bean.Projects;
import com.example.luoxiaozhuo.myapplication.mvvm.bean.Status;
import com.example.luoxiaozhuo.myapplication.mvvm.db.ProjectDBHelper;
import com.example.luoxiaozhuo.myapplication.mvvm.repository.ProjectRepository;
import com.example.luoxiaozhuo.myapplication.mvvm.vm.ProjectViewModel;

import java.util.List;


public class MyStartFragment extends Fragment {

    public static MyStartFragment instance;

    public static MyStartFragment newInstance() {

        if (instance == null) {
            instance = new MyStartFragment();
        }

        return instance;
    }

    View vContent;

    View vError;

    View vLoading;

    View vEmpty;

    SwipeRefreshLayout srl;

    RecyclerView rv;

    ProjectsAdapter projectsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mystart,container,false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("test","onActivityCreated----");
        initData();
        vContent = getActivity().findViewById(R.id.v_content);
        vError = getActivity().findViewById(R.id.v_error);
        vLoading = getActivity().findViewById(R.id.v_loading);
        vEmpty = getActivity().findViewById(R.id.v_empty);


        srl = getActivity().findViewById(R.id.srl);
        rv = getActivity().findViewById(R.id.rv);


        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        projectsAdapter = new ProjectsAdapter();
        rv.setAdapter(projectsAdapter);

        initEvent();
    }

    ProjectViewModel vm;

    private void initData() {
        ProjectDBHelper.getInstance().init(getActivity());
        ProjectRepository.getInstance().init(getActivity());
        listStatus = ListStatus.Content;
        vm = ViewModelProviders.of(this).get(ProjectViewModel.class);
        vm.getProjects().observe(this, (data) -> {
//            listStatus = ListStatus.Content;
            updateView(data);
        });
        reload();

    }

    Status status;

    private void updateView(Lcee<Projects> lcee) {
        status = lcee.status;
        switch (lcee.status) {
            case Content: {
                updateContentView(lcee.data);
                break;
            }
            case Empty: {
                updateEmptyView();
                break;
            }
            case Error: {
                updateErrorView();
                break;
            }
            case Loading: {
                updateLoadingView();
                break;
            }
        }
    }

    private void initEvent() {
        View.OnClickListener reloadListener = (view -> {
            reload();
        });
        vEmpty.setOnClickListener(reloadListener);
        vError.setOnClickListener(reloadListener);

        srl.setOnRefreshListener(() -> {
            if (isLoading()) {
                srl.setRefreshing(false);
                return;
            }
            listStatus = ListStatus.Refreshing;
            reload();
        });

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int mLastVisibleItemPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    mLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                }
                if (projectsAdapter == null)
                    return;

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && mLastVisibleItemPosition + 1 == projectsAdapter.getItemCount()) {

                    if (isLoading())
                        return;
                    listStatus = ListStatus.LoadingMore;
                    loadMore();
                }
            }
        });
    }


    /**
     * reload the data
     */
    private void reload() {
        vm.reload();
    }

    /**
     * load more data
     */
    private void loadMore() {
        vm.loadMore(projectsAdapter.getItemCount());
    }

    private void updateContentView(Projects projects) {
        switch (listStatus) {
            case LoadingMore: {
                projectsAdapter.addData(projects.getItems());
                // todo load more complete

                break;
            }
            case Refreshing: {
                srl.setRefreshing(false);
                break;
            }
            default: {
                showContent();
                projectsAdapter.setData(projects.getItems());
                break;
            }
        }
    }

    private void updateLoadingView() {
        switch (listStatus) {
            case LoadingMore: {
                // todo show loading more view in list footer

                break;
            }
            case Refreshing: {

                break;
            }
            default: {
                showLoading();
                break;
            }
        }
    }
    private void updateErrorView() {
        switch (listStatus) {
            case LoadingMore: {
                // todo load more error

                break;
            }
            case Refreshing: {
                srl.setRefreshing(false);
                Toast.makeText(this.getActivity(), "Refresh failed", Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                showError();
                break;
            }
        }
    }
    ListStatus listStatus = ListStatus.Content;
    private void updateEmptyView() {
        switch (listStatus) {
            case LoadingMore: {
                // todo no more data

                break;
            }
            case Refreshing: {
                srl.setRefreshing(false);
                showEmpty();
                break;
            }
            default: {
                showEmpty();
                break;
            }
        }
    }

    public enum ListStatus {
        Refreshing,
        LoadingMore,
        Content,
    }

    private void showContent() {
        vContent.setVisibility(View.VISIBLE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.GONE);
    }

    private void showEmpty() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.VISIBLE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.GONE);
    }

    private void showError() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.VISIBLE);
        vLoading.setVisibility(View.GONE);
    }

    private void showLoading() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.VISIBLE);
    }

    private boolean isLoading() {
        return status == Status.Loading;
    }
}
