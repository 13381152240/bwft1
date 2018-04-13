package com.example.administrator.bwft3.network.constant;

import com.example.administrator.bwft3.entity.LoginBean;
import com.example.administrator.bwft3.entity.RegisBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hasee on 2017/10/8.
 */

public interface IRegisterApi {
    //登录
    @FormUrlEncoded
    @POST(UrlUtils.LOGIN)
    Observable<LoginBean> login(@Field("phone") String mo, @Field("password") String pas);

    //注册
    @FormUrlEncoded
    @POST(UrlUtils.REG)
    Observable<RegisBean> reg(@Field("phone") String mo, @Field("password1") String pa1,@Field("password2") String pas2,@Field("code") String code,@Field("tuijian") String tuijian);

}