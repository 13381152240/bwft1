package com.example.administrator.bwft3.ui.model;
import com.example.administrator.bwft3.entity.LoginBean;
import com.example.administrator.bwft3.network.constant.IRegisterApi;
import com.example.administrator.bwft3.network.constant.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by alienware on 2018/4/12.
 */

public class LoginModel implements IModelLogin{

    @Override
    public Observable<LoginBean> login(String username, String password) {
        return RetrofitManager.getDefault().create(IRegisterApi.class).login(username,password);
        //RetrofitManager.getDefault().create(IRegisterApi.class).register()

    }
}
