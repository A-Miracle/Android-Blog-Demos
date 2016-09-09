package com.ctao.demos.blogcodes.mvp.view;

import com.ctao.demos.blogcodes.mvp.bean.User;

//View 面向接口
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
