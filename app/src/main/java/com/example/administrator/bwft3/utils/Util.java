package com.example.administrator.bwft3.utils;



import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 吕楠 on 2018/4/9.
 */

public class Util {

    private static OkHttpClient okHttpClient = null;

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            return okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }



    public static  void getDataInGet(String url,final BasecallBack basecallBack){
        Request request = new Request.Builder().url(url).build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String baseMessage = response.body().string();
                basecallBack.successsful(baseMessage);
            }
        });
    }

    public static void getDataInPost(String url, RequestBody formBody, final BasecallBack basecallBack){

        Request request = new Request.Builder().url(url).post(formBody).build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                basecallBack.successsful(response.body().string());
            }
        });
    }

//    public static void getDataFromRetrofit(String baseurl, final BasecallBack basecallBack){
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
//        ApiSeverce severce = retrofit.create(ApiSeverce.class);
//        severce.sendGet().enqueue(new retrofit2.Callback<MyRetrofitbean>() {
//            @Override
//            public void onResponse(retrofit2.Call<MyRetrofitbean> call, retrofit2.Response<MyRetrofitbean> response) {
//                Log.e("网络请求成功",response.body().getMessage());
//                basecallBack.successsful(response.body().getMessage());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<MyRetrofitbean> call, Throwable t) {
//                Log.e("网络请求失败",t.getMessage());
//                basecallBack.fuildye(t.getMessage());
//            }
//        });
//    }




}
