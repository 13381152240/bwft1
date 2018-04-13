package com.example.administrator.bwft3.ui.model;

import com.example.administrator.bwft3.entity.RegisBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/4/13.
 */

public interface IModelReg  {
    Observable<RegisBean> reg(String mo, String pas1, String pas2, String code,String tuijian);
}
