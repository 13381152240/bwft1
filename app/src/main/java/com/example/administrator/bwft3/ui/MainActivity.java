package com.example.administrator.bwft3.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.entity.LoginBean;
import com.example.administrator.bwft3.ui.presenter.LoginPresenter;
import com.example.administrator.bwft3.ui.register.RegisterActivity;
import com.example.administrator.bwft3.ui.view.IL;
import com.example.administrator.bwft3.utils.ClearEditText;
import com.example.administrator.bwft3.utils.PopupwindowUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.vondear.rxtools.RxActivityTool;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TextWatcher,IL {

    @BindView(R.id.usered)
    ClearEditText usered;
    @BindView(R.id.passed)
    ClearEditText passed;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.forgettv)
    TextView forgettv;
    @BindView(R.id.regintv)
    TextView regintv;
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    @BindView(R.id.togglePwd)
    ToggleButton togglePwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.userargee)
    TextView userargee;
    @BindView(R.id.logQQ)
    ImageView logQQ;
    @BindView(R.id.logWeixin)
    ImageView logWeixin;
    @BindView(R.id.logwb)
    ImageView logwb;
    String user;
    String pass;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        passed.addTextChangedListener(this);
        login.setEnabled(false);
        mTencent = Tencent.createInstance(APP_ID, MainActivity.this.getApplicationContext());
        initview();
        //实例化p层
        loginPresenter = new LoginPresenter(this);


    }

    private void initview() {
        userargee.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        togglePwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    passed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    passed.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        login.setEnabled(false);//在这里重复设置，以保证清除任意EditText中的内容，按钮重新变回不可点击状态
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!(passed.getText().toString().equals(""))) {
            login.setEnabled(true);
            login.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));

        }
    }

    @OnClick({R.id.logQQ, R.id.logWeixin, R.id.logwb, R.id.login, R.id.usered, R.id.passed,R.id.forgettv, R.id.regintv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.logQQ:
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(MainActivity.this, "all", mIUiListener);
                break;
            case R.id.logWeixin:
                break;
            case R.id.forgettv:
                //RxActivityTool.skipActivity(MainActivity.this, BackPSPhoneActivity.class);
                break;
            case R.id.regintv:
                RxActivityTool.skipActivity(MainActivity.this, RegisterActivity.class);
                break;
            case R.id.logwb:
                break;
            case R.id.login:
                user = usered.getText().toString().trim();
                pass = passed.getText().toString().trim();

                loginPresenter.getlogin(user,pass);
                break;

        }
}

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void getlogin(LoginBean loginBean) {
        if(loginBean.getStatus()==1){
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
            RxActivityTool.skipActivity(this,ZhuActivity.class);
        }else{
//            View aalayout = View.inflate(MainActivity.this, R.layout.alert, null);
//            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//MainActivity.this为当前环境
//            builder.setPositiveButton(R.string.sure, null);
//            builder.setCancelable(true);
//            builder.setView(aalayout);
//            builder.create().show();
            PopupwindowUtil popupwindowUtil = new PopupwindowUtil();
            popupwindowUtil.setPop(this,"登录失败","账号或密码错误,请重新输入");

            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void registerFaid() {

    }


    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG, "登录成功" + response.toString());


                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
