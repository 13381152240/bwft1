package com.example.administrator.bwft3.ui.model;

import com.example.administrator.bwft3.entity.LoginBean;

import io.reactivex.Observable;

/**
 * Created by alienware on 2018/4/12.
 */

public interface IModelLogin {
    Observable<LoginBean> login(String username, String password);

}
