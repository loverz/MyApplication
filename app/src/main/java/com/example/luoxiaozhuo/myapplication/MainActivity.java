package com.example.luoxiaozhuo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
//
//import com.example.luoxiaozhuo.myapplication.fg.MainFragment;
//import com.example.luoxiaozhuo.myapplication.fg.MyStartFragment;
//import com.example.luoxiaozhuo.myapplication.mvvm.db.ProjectDBHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
//
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//
//
//                    mTextMessage.setText(R.string.title_home);
//
//
//
//                    return true;
//                case R.id.navigation_dashboard: {
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, MainFragment.newInstance())
//                            .commitNow();
//                }
//
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setVisibility(View.GONE);
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, MyStartFragment.newInstance())
//                            .commitNow();
//                    return true;
//            }
//            return false;
//        }
//    };
    public static final int OVERLAY_PERMISSION_REQ_CODE = 10001;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if(Settings.canDrawOverlays(MainActivity.this)) {
                        Log.e("test","Settings.canDrawOverlays");
                        Intent i = new Intent(MainActivity.this,MyRNAct.class);

                        startActivity(i);
                    }
                }
            }
        });
//        mTextMessage.setOnClickListener((view)->{
//
//        });
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
        // init database
//        ProjectDBHelper.getInstance().init(this);
    }

}
