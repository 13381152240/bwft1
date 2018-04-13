package com.example.administrator.bwft3.network.constant;

import com.example.administrator.bwft3.entity.LoginBean;

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

}