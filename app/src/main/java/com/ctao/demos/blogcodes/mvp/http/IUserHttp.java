package com.ctao.demos.blogcodes.mvp.http;

import com.ctao.demos.blogcodes.mvp.bean.User;

/**
 * Created by A Miracle on 2016/9/9.
 */
//Modle 业务抽象接口
public interface IUserHttp {
    void login(String username, String password, OnResultListener<User> listener);
}
