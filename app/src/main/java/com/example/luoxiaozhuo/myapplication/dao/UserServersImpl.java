package com.example.luoxiaozhuo.myapplication.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.luoxiaozhuo.myapplication.bean.User;

/**
 * 此实现保证所使用的数据库操作在线程中进行，不卡主线程
 */
public class UserServersImpl implements UserService {
    public static UserServersImpl instance = new UserServersImpl();

    private UserDao userDao = DBHelper.getInstance().getDb().getUserDao();

    @Override
    public LiveData<Long> add(final User user) {
        final MutableLiveData<Long> data = new MutableLiveData<>();
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                return userDao.add(user);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                data.setValue(aLong);
            }
        }.execute();

        return data;
    }

    @Override
    public LiveData<User> queryByName(String name) {
        return userDao.queryByName(name);
    }
}
