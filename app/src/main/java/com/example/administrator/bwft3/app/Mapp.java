package com.example.administrator.bwft3.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/10.
 */

public class Mapp extends Application{
    private static Mapp mapp;
    private static Mapp context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        this.context = this;
    }
    public static Context context(){
        return context;
    }

    private static Map<String,Activity> destoryMap = new HashMap<>();

//    private Mapp() {
//    }
//
//    public static Mapp getInstance() {
//        if(null ==mapp){
//            synchronized (Mapp.class){
//                if (null == mapp){
//                    mapp=new Mapp();
//                }
//            }
//        }
//        return mapp;
//    }
    /**
     * 添加到销毁队列
     *
     * @param activity 要销毁的activity
     */

    public static void addDestoryActivity(Activity activity,String activityName) {
        destoryMap.put(activityName,activity);
    }
    /**
     *销毁指定Activity
     */
    public static void destoryActivity(String activityName) {
        Set<String> keySet=destoryMap.keySet();
        for (String key:keySet){
            destoryMap.get(key).finish();
        }
    }

}
