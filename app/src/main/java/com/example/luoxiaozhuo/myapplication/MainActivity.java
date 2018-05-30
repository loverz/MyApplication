package com.example.luoxiaozhuo.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.luoxiaozhuo.myapplication.fg.MainFragment;
import com.example.luoxiaozhuo.myapplication.fg.MyStartFragment;
import com.example.luoxiaozhuo.myapplication.mvvm.db.ProjectDBHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, MainFragment.newInstance())
                            .commitNow();
                }

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, MyStartFragment.newInstance())
                            .commitNow();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // init database
//        ProjectDBHelper.getInstance().init(this);
    }

}
