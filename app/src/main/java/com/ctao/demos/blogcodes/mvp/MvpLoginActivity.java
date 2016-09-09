package com.ctao.demos.blogcodes.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ctao.demos.R;
import com.ctao.demos.blogcodes.mvp.bean.User;
import com.ctao.demos.blogcodes.mvp.http.imp.UserHttpImp;
import com.ctao.demos.blogcodes.mvp.presenter.UserLoginPresenter;
import com.ctao.demos.blogcodes.mvp.view.IUserLoginView;

/**
 * Created by A Miracle on 2016/9/9.
 */
//View Activity就只负责与界面相关的View的展示
public class MvpLoginActivity extends AppCompatActivity implements View.OnClickListener, IUserLoginView {

    private ProgressDialog mPdLoading;
    private EditText et_username;
    private EditText et_password;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this, new UserHttpImp());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvclogin);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        mPdLoading = new ProgressDialog(this);

        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
        }
    }

    //登录
    private void login() {
        mUserLoginPresenter.login();
    }

    @Override
    public String getUserName() {
        return et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void showLoading() {
        mPdLoading.show();
    }

    @Override
    public void hideLoading() {
        mPdLoading.dismiss();
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
