package com.example.administrator.bwft3.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.bwft3.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_test;
    private Button but_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        tv_test = (TextView) findViewById(R.id.tv_test);
        but_test = (Button) findViewById(R.id.but_test);

        but_test.setOnClickListener(this);
    }

    private void initOK() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder form = new FormBody.Builder();
        form.add("phone","17600769829");
        form.add("password1","20000720");
        form.add("password2","20000720");
        form.add("code","1234");
        form.add("tuijian","13700000000");
        Request request = new Request.Builder().url("http://lw.xiandouxian.cn/index.php/Api/Pub/reg").post(form.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("123456789","13131");
                Log.e("返回的数据",response.body().string());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_test:
                initOK();
                break;
        }
    }
}
