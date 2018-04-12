package com.example.administrator.bwft3.utils;


import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/12.
 */

public class Request {

        private String string;

        public String initOK(final String request, String phone, String password1, String password2, String code, String tuijian) {
                OkHttpClient okHttpClient = new OkHttpClient();
                FormBody.Builder form = new FormBody.Builder();
                form.add("phone",phone);
                form.add("password1",password1);
                form.add("password2",password2);
                form.add("code",code);
                form.add("tuijian",tuijian);
                okhttp3.Request requests = new okhttp3.Request.Builder().url(request).post(form.build()).build();
                okHttpClient.newCall(requests).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                                string = response.body().string();
                        }
                });
                Log.e("aaa",string);
                return string;
        }
}
