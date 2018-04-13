package com.example.administrator.bwft3.ui.model;

import com.example.administrator.bwft3.entity.RegisBean;
import com.example.administrator.bwft3.network.constant.IRegisterApi;
import com.example.administrator.bwft3.network.constant.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/4/13.
 */

public class RegModel implements IModelReg {
    @Override
    public Observable<RegisBean> reg(String mo, String pas1, String pas2, String code, String tuijian) {

        return RetrofitManager.getDefault().create(IRegisterApi.class).reg(mo,pas1,pas2,code,tuijian);
    }
}
