package com.ctao.demos.blogcodes.mvc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ctao.demos.R;
import com.ctao.demos.blogcodes.mvc.bean.User;
import com.ctao.demos.blogcodes.mvc.http.UserLoginHttp;

import java.util.List;

/**
 * Created by A Miracle on 2016/9/9.
 */
//Controller Activity
public class MvcLoginAvtivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog mPdLoading;
    private EditText et_username;
    private EditText et_password;

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
        //TODO 业务和界面的交互
        mPdLoading.show();
        UserLoginHttp loginHttp = new UserLoginHttp(new Handler());
        loginHttp.login(et_username.getText().toString(), et_password.getText().toString(), new UserLoginHttp.onResultListener<User>() {
            @Override
            public boolean onResult(int state, List<User> data, User user) {
                mPdLoading.dismiss();
                if (state == UserLoginHttp.STATE_SUCCEED) {
                    Toast.makeText(getApplication(), user.getUsername() +
                            " login success , to MainActivity", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(),
                            "login failed", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}