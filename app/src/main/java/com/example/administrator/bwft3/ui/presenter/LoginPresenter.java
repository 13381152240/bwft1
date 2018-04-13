package com.example.administrator.bwft3.ui.presenter;
import com.example.administrator.bwft3.entity.LoginBean;
import com.example.administrator.bwft3.ui.model.LoginModel;
import com.example.administrator.bwft3.ui.view.IL;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alienware on 2018/4/12.
 */

public class LoginPresenter extends IPresenter<IL> {
    private LoginModel loginModel;
    public LoginPresenter(IL view) {
        super(view);
    }

    @Override
    protected void init() {
        loginModel = new LoginModel();
    }

    public void getlogin(String username,String password){
        //model提供对应的被观察者
        Observable<LoginBean> registerObservable = loginModel.login(username,password);

        registerObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        if(view!=null){
                            view.getlogin(loginBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(view!=null){
                            view.registerFaid();
                        }
                    }
                });




    }



}
