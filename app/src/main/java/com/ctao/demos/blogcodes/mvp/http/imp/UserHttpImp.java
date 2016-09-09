package com.ctao.demos.blogcodes.mvp.http.imp;

import android.os.Handler;

import com.ctao.demos.blogcodes.mvp.bean.User;
import com.ctao.demos.blogcodes.mvp.http.IUserHttp;
import com.ctao.demos.blogcodes.mvp.http.OnResultListener;

/**
 * Created by A Miracle on 2016/9/9.
 */
//Modle 业务实现
public class UserHttpImp implements IUserHttp {

    private Handler mHandler = new Handler(); //Demo, 在此简单处理

    @Override
    public void login(final String username, final String password, final OnResultListener<User> listener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("123".equals(username) && "123".equals(password)) {
                    final User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onResult(OnResultListener.STATE_SUCCEED, null, user);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onResult(OnResultListener.STATE_ERROR, null, null);
                        }
                    });
                }
            }
        }.start();
    }
}
