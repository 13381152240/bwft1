package com.example.administrator.bwft3.ui.forgetpass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.ui.register.PopupwindowUtil;

public class BackPSSetPSActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean flag2 = false;
    private boolean flag3 = false;
    private ImageView title_return;
    private TextView tv_title;
    private EditText setpas_password;
    private ImageView setpas_passwordsee;
    private EditText setpas_passwordagain;
    private ImageView setpas_passwordagainsee;
    private Button setpasbut_register;
    private ImageView setpas_passwordnull;
    private ImageView setpas_passwordagainnull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_psset_ps);
        initView();
        initData();
    }

    private void initData() {
        tv_title.setText("用户注册");
    }


    private void initView() {
        title_return = (ImageView) findViewById(R.id.title_return);
        tv_title = (TextView) findViewById(R.id.tv_title);
        setpas_password = (EditText) findViewById(R.id.setpas_password);
        setpas_password.addTextChangedListener(editclick);
        setpas_passwordsee = (ImageView) findViewById(R.id.setpas_passwordsee);
        setpas_passwordagain = (EditText) findViewById(R.id.setpas_passwordagain);
        setpas_passwordagain.addTextChangedListener(editclick);
        setpas_passwordagainsee = (ImageView) findViewById(R.id.setpas_passwordagainsee);
        setpasbut_register = (Button) findViewById(R.id.setpasbut_register);
        setpasbut_register.setOnClickListener(this);
        setpas_passwordsee.setOnClickListener(this);
        setpas_passwordagainsee.setOnClickListener(this);
        title_return.setOnClickListener(this);
        setpas_passwordnull = (ImageView) findViewById(R.id.setpas_passwordnull);
        setpas_passwordnull.setOnClickListener(this);
        setpas_passwordagainnull = (ImageView) findViewById(R.id.setpas_passwordagainnull);
        setpas_passwordagainnull.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setpasbut_register:
                String s = setpas_password.getText().toString();
                String s1 = setpas_passwordagain.getText().toString();
                if (s.equals(s1)) {
                    Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                } else {
                    PopupwindowUtil popupwindowUtil = new PopupwindowUtil();
                    popupwindowUtil.setPop(this, "提示", "两次输入密码不一致");
                }
                break;
            case R.id.setpas_passwordsee:
                if (flag2 == false) {
                    flag2 = true;
                    setpas_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    flag2 = false;
                    setpas_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.setpas_passwordagainsee:
                if (flag3 == false) {
                    flag3 = true;
                    setpas_passwordagain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    flag3 = false;
                    setpas_passwordagain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.title_return:
                finish();
                break;
            case R.id.setpas_passwordnull:
                setpas_password.setText("");
                break;
            case R.id.setpas_passwordagainnull:
                setpas_passwordagain.setText("");
                break;
        }
    }

    private void submit() {
        // validate
        String password = setpas_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "登录密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordagain = setpas_passwordagain.getText().toString().trim();
        if (TextUtils.isEmpty(passwordagain)) {
            Toast.makeText(this, "确认登录密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    private TextWatcher editclick = new TextWatcher() {


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        //一般我们都是在这个里面进行我们文本框的输入的判断，上面两个方法用到的很少
        @Override
        public void afterTextChanged(Editable s) {
            String password = setpas_password.getText().toString();
            String edpasswordaggin = setpas_passwordagain.getText().toString();
            if (password.equals("")) {
                setpas_passwordnull.setVisibility(View.GONE);
            }else {
                setpas_passwordnull.setVisibility(View.VISIBLE);
            }
            if (edpasswordaggin.equals("")){
                setpas_passwordagainnull.setVisibility(View.GONE);
            }else {
                setpas_passwordagainnull.setVisibility(View.VISIBLE);
            }
            if (password.equals("") && edpasswordaggin.equals("")) {
                setpasbut_register.setEnabled(false);
                setpasbut_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));
            } else {
                setpasbut_register.setEnabled(true);
                setpasbut_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));
            }
        }
    };
}
