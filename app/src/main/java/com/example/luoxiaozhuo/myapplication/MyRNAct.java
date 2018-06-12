package com.example.luoxiaozhuo.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

public class MyRNAct extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    private ReactRootView mRNRootView;

    private ReactInstanceManager mRNInstanceMgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRNRootView = new ReactRootView(this);
        mRNInstanceMgr = ReactInstanceManager.builder().setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        mRNRootView.startReactApplication(mRNInstanceMgr, "rn_test", null);

    }


    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mRNInstanceMgr != null) {
            mRNInstanceMgr.onPause();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mRNInstanceMgr != null) {
            mRNInstanceMgr.onResume(this,this);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mRNInstanceMgr != null) {
            mRNInstanceMgr.onDestroy();
        }
    }
}
