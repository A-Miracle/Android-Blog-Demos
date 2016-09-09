package com.ctao.demos.blogcodes.mvvm.http;

import android.os.Handler;
import android.os.SystemClock;

import com.ctao.demos.blogcodes.mvvm.bean.User;

import java.util.List;

/**
 * Created by A Miracle on 2016/9/9.
 */
//Model 业务
public class UserLoginHttp {

    /** 请求异常 */
    public static final int STATE_ERROR = -1;
    /** 请求成功 */
    public static final int STATE_SUCCEED = 0x11;
    /** 请求成功, 无数据 */
    public static final int STATE_SUCCEED_EMPTY = 0x22;
    /** 请求成功, JSON异常 */
    public static final int STATE_SUCCEED_JSON_ERROR = 0x33;
    /** 未请求 */
    public static final int STATE_UNGEBETEN = 0x44;

    public interface onResultListener<T> {
        /**
         * 请求结果返回
         * @param state 状态码
         * @param data List集合返回
         * @param result json字符串返回
         * @return 是否自行处理结果
         */
        boolean onResult(int state, List<T> data, T result);
    }

    //--------------------上部分可抽取为公用, 这里只是简单demo-------------------

    private Handler handler;

    public UserLoginHttp(Handler handler){
        this.handler = handler;
    }

    public void login(final String username, final String password, final onResultListener<User> loginListener) {

        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                if ("123".equals(username) && "123".equals(password)) {
                    final User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            loginListener.onResult(STATE_SUCCEED, null, user);
                        }
                    });

                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            loginListener.onResult(STATE_ERROR, null, null);
                        }
                    });
                }
            }
        }.start();
    }
}
