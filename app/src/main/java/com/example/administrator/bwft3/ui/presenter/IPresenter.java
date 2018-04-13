package com.example.administrator.bwft3.ui.presenter;

import android.content.Context;

import com.example.administrator.bwft3.app.Mapp;
import com.example.administrator.bwft3.ui.view.IView;

/**
 * Created by hasee on 2017/10/8.
 */

public class IPresenter<T extends IView> {
    protected T view;

    public IPresenter(T view) {
        this.view = view;
        init();
    }

    protected void init() {

    }

    public Context context() {
        if (view != null && view.context() != null) {
            return view.context();
        }
        return Mapp.context();
    }
}