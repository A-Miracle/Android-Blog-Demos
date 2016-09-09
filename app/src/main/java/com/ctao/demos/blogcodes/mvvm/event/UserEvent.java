package com.ctao.demos.blogcodes.mvvm.event;

import android.text.Editable;
import android.text.TextWatcher;

import com.ctao.demos.blogcodes.mvvm.bean.User;

/**
 * Created by A Miracle on 2016/9/9.
 */
//View (和Layout组合成View)
public class UserEvent {

    private User user;

    public UserEvent(User user){
        this.user = user;
    }

    public TextWatcher usernameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            user.setUsername(editable.toString());
        }
    };

    public TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            user.setPassword(editable.toString());
        }
    };
}
