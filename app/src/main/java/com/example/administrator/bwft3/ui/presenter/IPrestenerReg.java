package com.example.administrator.bwft3.ui.presenter;

import com.example.administrator.bwft3.entity.RegisBean;
import com.example.administrator.bwft3.ui.model.LoginModel;
import com.example.administrator.bwft3.ui.model.RegModel;
import com.example.administrator.bwft3.ui.view.IL;
import com.example.administrator.bwft3.ui.view.IR;
import com.example.administrator.bwft3.ui.view.IView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/13.
 */

public class IPrestenerReg extends IPresenter<IR> {
    private RegModel regModel;
    public IPrestenerReg(IR view) {
        super(view);
    }

    @Override
    protected void init() {
        regModel = new RegModel();
    }

    public void getlogin(String mo, String pas1, String pas2, String code, String tuijian){
        //model提供对应的被观察者
        Observable<RegisBean> registerObservable = regModel.reg(mo, pas1, pas2, code, tuijian);

        registerObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisBean>() {
                    @Override
                    public void accept(RegisBean regisBean) throws Exception {
                        if(view!=null){
                            view.getReg(regisBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(view!=null){
                            view.regFaid();
                        }
                    }
                });




    }

}
