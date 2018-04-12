package com.example.administrator.bwft3.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyInterceptor implements Interceptor {
    private static final int DEFAULT_TIMEOUT = 30; //此处默认超时时间为30s
    private TimeUnit mTimeUnitSECONDS = TimeUnit.SECONDS;
    private OkHttpClient.Builder build = new OkHttpClient.Builder();

    public OkHttpClient build() {
        return build.build();
    }

    public MyInterceptor addTimeOut(int timeOut) {
        if (timeOut <= 0) timeOut = DEFAULT_TIMEOUT;
        build.connectTimeout(timeOut, mTimeUnitSECONDS)
                .writeTimeout(timeOut, mTimeUnitSECONDS)
                .readTimeout(timeOut, mTimeUnitSECONDS);
        return this;
    }
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {

        Request orinal = chain.request();
        HttpUrl url = orinal.url()
                .newBuilder()
                .addQueryParameter("","")
                .build();

        Request build = orinal.newBuilder()
                .url(url)
                .build();

        return chain.proceed(build);
    }
}