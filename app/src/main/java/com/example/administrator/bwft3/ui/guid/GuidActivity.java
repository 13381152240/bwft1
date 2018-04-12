package com.example.administrator.bwft3.ui.guid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.bwft3.MainActivity;
import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.adapter.GuidAdapter;
import com.example.administrator.bwft3.ui.ZhuActivity;
import com.example.administrator.bwft3.utils.ACache;
import com.vondear.rxtools.RxActivityTool;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GuidActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private LinearLayout liner;
    private Button btn;
    private List<ImageView> list;
    private List<ImageView> yuandian;
    private ArrayList<Integer> arrayLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        initView();
//        //设置图片集合
        arrayLists = new ArrayList<>();
        arrayLists.add(R.drawable.app_loading0);
        arrayLists.add(R.drawable.app_loading1);
        arrayLists.add(R.drawable.app_loading2);
        arrayLists.add(R.drawable.app_loading3);
//        //获取数据库
        String isoneguid1 = ACache.get(getApplication()).getAsString("isoneguid");
            if(null!=isoneguid1){
                if ("1".equals(isoneguid1)){
                    RxActivityTool.skipActivity(this, ZhuActivity.class);
                }
            }

        initView();
        initData();
        initAdapter();
        initListener();

    }

    private void initAdapter() {
        GuidAdapter adapter = new GuidAdapter(list);
        vp.setAdapter(adapter);
        vp.setCurrentItem(0);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < arrayLists.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(arrayLists.get(i));
            //图片自适应
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(imageView);
        }
        yuandian = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            //设置圆点属性
            lp.height=10;
            lp.width=10;
            lp.leftMargin=18;
            lp.rightMargin=18;
            //判断当前ViewPager索引，然后设置底部圆点样式
            if (i==0){
                imageView.setBackgroundResource(R.drawable.shape_yindaoyetwo);
            }else {
                imageView.setBackgroundResource(R.drawable.shape_yindaoyeone);
            }
            imageView.setLayoutParams(lp);
            liner.addView(imageView);
            yuandian.add(imageView);
        }
    }

    private void initListener() {
        //viewpager的滑动监听
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 3; i++) {
                    if (position==i){
                        yuandian.get(i).setBackgroundResource(R.drawable.shape_yindaoyetwo);
                    }else {
                        yuandian.get(i).setBackgroundResource(R.drawable.shape_yindaoyeone);
                    }
                }
                if (position==list.size()-1){
                    //设置显示
                    btn.setVisibility(View.VISIBLE);
                    //设置隐藏
                    liner.setVisibility(View.INVISIBLE);
                }
                if (position<list.size()-1){
                    btn.setVisibility(View.INVISIBLE);
                    liner.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        liner = (LinearLayout) findViewById(R.id.liner);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                RxActivityTool.skipActivity(this, ZhuActivity.class);
                ACache.get(getApplication()).put("isoneguid", "1");
                break;
        }
    }


}
