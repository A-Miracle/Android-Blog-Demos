package com.ctao.demos.blogcodes.mvp.presenter;

import com.ctao.demos.blogcodes.mvp.bean.User;
import com.ctao.demos.blogcodes.mvp.http.IUserHttp;
import com.ctao.demos.blogcodes.mvp.http.OnResultListener;
import com.ctao.demos.blogcodes.mvp.view.IUserLoginView;

import java.util.List;

/**
 * Created by zhy on 15/6/19.
 */
//Presenter 完成View和Model的交互
public class UserLoginPresenter {
    private IUserHttp userHttp;
    private IUserLoginView userLoginView;

    public UserLoginPresenter(IUserLoginView userLoginView, IUserHttp userHttp) {
        this.userLoginView = userLoginView;
        this.userHttp = userHttp;
    }

    public void login() {
        userLoginView.showLoading();
        userHttp.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnResultListener<User>() {
            @Override
            public boolean onResult(final int state, List<User> data, final User user) {
                if (state == OnResultListener.STATE_SUCCEED) {
                    userLoginView.toMainActivity(user);
                    userLoginView.hideLoading();
                } else {
                    userLoginView.showFailedError();
                    userLoginView.hideLoading();
                }
                return false;
            }
        });
    }
}
