package com.example.administrator.bwft3.network.constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private Retrofit mRetrofit;
    private static final String DEFUALT_BASE_URL = "http://lw.xiandouxian.cn/index.php/Api/";
    public static final String LOGIN="Pub/login";
    //一种单例模式
    private static class SingleHolder {
        private static final RetrofitManager _instance = new RetrofitManager(DEFUALT_BASE_URL);
    }


    //使用默认的单例RetrofitManager，是默认的baseurl
    public static RetrofitManager getDefault() {
        return SingleHolder._instance;
    }

    //如果baseurl不是默认的话，那就调用这个方法构造一个新的RetrofitManager
    public static RetrofitManager getRetrofitManager(String baseUrl) {
        return new RetrofitManager(baseUrl);
    }

    private RetrofitManager(String baseUrl) {
        this.mRetrofit = buildRetrofit(baseUrl);
    }

    private Retrofit buildRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.build();
    }

    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

}