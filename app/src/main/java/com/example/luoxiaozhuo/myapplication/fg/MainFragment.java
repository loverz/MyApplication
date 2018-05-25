package com.example.luoxiaozhuo.myapplication.fg;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.luoxiaozhuo.myapplication.R;
import com.example.luoxiaozhuo.myapplication.bean.UserBean;
import com.example.luoxiaozhuo.myapplication.ld.MyLiveViewData;
import com.example.luoxiaozhuo.myapplication.ld.OnValueChangeListener;
import com.example.luoxiaozhuo.myapplication.vm.MyViewModel;

public class MainFragment extends Fragment {

    public static MainFragment instance;

    MyViewModel myViewModel;


    Button mBtn;
    TextView mTxt;



    OnValueChangeListener onValueChangeBtnOberser ;

    MyLiveViewData mData;
   public static MainFragment newInstance(){

       if(instance == null) {
           instance = new MainFragment();
       }

       return instance;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fg,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mData = new MyLiveViewData();
        mBtn = getActivity().findViewById(R.id.button);
        mTxt = getActivity().findViewById(R.id.txt_name);
        onValueChangeBtnOberser = value -> {

        };


        mData.observer(onValueChangeBtnOberser);

        myViewModel.getUser().observe(this,(userBean -> {
            updateView(userBean);
        }));

        mBtn.setOnClickListener(((view) -> {
            myViewModel.setUser("test2222",1);
        }));

        myViewModel.getUserByName("ittianyu").observe(this,(user -> {

            Log.e("test",user.getName());
            mTxt.setText(user.getName());
        }));

    }

    private void updateView(UserBean userBean) {
       mBtn.setText(userBean.name);
    }
}
