package com.ctao.demos.blogcodes.mvvm;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ctao.demos.R;
import com.ctao.demos.blogcodes.mvvm.bean.User;
import com.ctao.demos.blogcodes.mvvm.event.UserEvent;
import com.ctao.demos.blogcodes.mvvm.http.UserLoginHttp;
import com.ctao.demos.databinding.ActivityMvvmloginBinding;

import java.util.List;


/**
 * Created by A Miracle on 2016/9/9.
 */
//ViewModel 通过DataBinding将View和Model联系在一起
public class MvvmLoginAvtivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog mPdLoading; // xml中没有, 不能分离
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView
        ActivityMvvmloginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmlogin);

        //绑定Event
        user = new User();
        UserEvent userEvent = new UserEvent(user);
        binding.setEvent(userEvent);

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
        //业务处理
        mPdLoading.show();
        UserLoginHttp loginHttp = new UserLoginHttp(new Handler());
        loginHttp.login(user.getUsername(), user.getPassword(), new UserLoginHttp.onResultListener<User>() {
            @Override
            public boolean onResult(int state, List<User> data, User result) {
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
