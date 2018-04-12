package com.example.administrator.bwft3.ui.car;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.network.GetRequest_Interface;
import com.example.administrator.bwft3.network.Translation;
import com.example.administrator.bwft3.network.UrlUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingcarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcar);
        request();

    }
    public void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlUtils.HOST) // 设置 网络请求 Url
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对 发送请求 进行封装

        Call<Translation> call = request.getCall();
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
                Toast.makeText(ShoppingcarActivity.this,"请求成功",Toast.LENGTH_SHORT).show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
                Toast.makeText(ShoppingcarActivity.this,"请求成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
