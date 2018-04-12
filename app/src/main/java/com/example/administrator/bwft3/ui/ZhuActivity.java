package com.example.administrator.bwft3.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bwft3.MainActivity;
import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.ui.car.ShoppingcarActivity;
import com.example.administrator.bwft3.ui.me.MeFragment;
import com.example.administrator.bwft3.ui.near.Nearfragment;
import com.example.administrator.bwft3.ui.store.Storefragment;
import com.example.administrator.bwft3.ui.treasure.Treasfragment;
import com.vondear.rxtools.RxActivityTool;

import java.util.ArrayList;
import java.util.List;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> fragmentList = null;
    private FrameLayout fy_content;
    private Button btn_store;
    private Button btn_near;
    private TextView tv_shop_car;
    private Button btn_home;
    private Button btn_me;
    private LinearLayout radioGroup;
    private int currentShow = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
        initview();


    }

    private void initview() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Storefragment());
        fragmentList.add(new Nearfragment());
        fragmentList.add(new Treasfragment());
        fragmentList.add(new MeFragment());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fy_content, fragmentList.get(0));
        ft.add(R.id.fy_content, fragmentList.get(1));
        ft.add(R.id.fy_content, fragmentList.get(2));
        ft.add(R.id.fy_content, fragmentList.get(3));

        ft.hide(fragmentList.get(0));
        ft.hide(fragmentList.get(1));
        ft.hide(fragmentList.get(2));
        ft.hide(fragmentList.get(3));

        ft.show(fragmentList.get(currentShow = 0));
        btn_store.setSelected(true);
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private long mExitTime = 0;

    private void exit() {

        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }

    }

    private void initView() {
        fy_content = (FrameLayout) findViewById(R.id.fy_content);
        btn_store = (Button) findViewById(R.id.btn_store);
        btn_near = (Button) findViewById(R.id.btn_near);
        tv_shop_car = (TextView) findViewById(R.id.tv_shop_car);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_me = (Button) findViewById(R.id.btn_me);
        radioGroup = (LinearLayout) findViewById(R.id.radioGroup);
        tv_shop_car.setOnClickListener(this);
        btn_store.setOnClickListener(this);
        btn_near.setOnClickListener(this);
        btn_home.setOnClickListener(this);
        btn_me.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        btn_home.setSelected(false);
        btn_near.setSelected(false);
        btn_store.setSelected(false);
        btn_me.setSelected(false);
        v.setSelected(true);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragmentList.get(currentShow));

        switch (v.getId()) {
            case R.id.btn_store:
                ft.show(fragmentList.get(currentShow = 0));
                break;
            case R.id.btn_near:
                ft.show(fragmentList.get(currentShow = 1));
                break;
            case R.id.btn_home:
                ft.show(fragmentList.get(currentShow = 2));
                break;
            case R.id.btn_me:
                    RxActivityTool.skipActivity(this, MainActivity.class);
                ft.show(fragmentList.get(currentShow = 3));
                break;
            case  R.id.tv_shop_car:
                RxActivityTool.skipActivity(ZhuActivity.this, ShoppingcarActivity.class);
            default:
                break;
        }
        ft.commit();

    }
}
