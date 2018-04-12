package com.example.administrator.bwft3.ui.register;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.bwft3.MainActivity;
import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.utils.PopupwindowUtil;

public class RegisterPassWordActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_title;
    private EditText ed_password;
    private EditText ed_passwordagain;
    private Button but_register;
    private TextView tv_registerAgreementThree;
    private boolean flag = false;
    private ImageView title_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pass_word);
        initView();
    }


    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        ed_password = (EditText) findViewById(R.id.ed_password);
        ed_password.addTextChangedListener(editclick);
        isChecket(ed_password);
        ed_passwordagain = (EditText) findViewById(R.id.ed_passwordagain);
        ed_passwordagain.addTextChangedListener(editclick);
        isChecket(ed_passwordagain);
        but_register = (Button) findViewById(R.id.but_register);
        tv_registerAgreementThree = (TextView) findViewById(R.id.tv_registerAgreementThree);
        tv_registerAgreementThree.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_registerAgreementThree.getPaint().setAntiAlias(true);//抗锯齿
        but_register.setOnClickListener(this);

        title_return = (ImageView) findViewById(R.id.title_return);
        title_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_register:
                String s = ed_password.getText().toString();
                String s1 = ed_passwordagain.getText().toString();
                if (s.equals(s1)) {
                    Intent intent=new Intent(this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    PopupwindowUtil popupwindowUtil = new PopupwindowUtil();
                    popupwindowUtil.setPop(this,"提示","两次输入密码不一致");
                }
                break;
            case R.id.title_return:
                finish();
                break;
        }
    }

    private PopupWindow.OnDismissListener mDismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = 1.0f;
            getWindow().setAttributes(lp);
        }

    };

    public void isChecket(final EditText ed) {
        ed.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // et.getCompoundDrawables()得到一个长度为4的数组，分别表示左右上下四张图片
                Drawable drawable = ed.getCompoundDrawables()[2];
                //如果右边没有图片，不再处理
                if (drawable == null)
                    return false;
                //如果不是按下事件，不再处理
                if (event.getAction() != MotionEvent.ACTION_UP)
                    return false;
                if (event.getX() > ed.getWidth()
                        - ed.getPaddingRight()
                        - drawable.getIntrinsicWidth()) {
                    if (flag == false) {
                        ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        flag = true;
                    } else {
                        ed.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        flag = false;
                    }
                }
                return false;
            }
        });
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
            String password = ed_password.getText().toString();
            String edpasswordaggin = ed_passwordagain.getText().toString();
            if (password.equals("") && edpasswordaggin.equals("")) {
                but_register.setEnabled(false);
                but_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));
            } else {
                but_register.setEnabled(true);
                but_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));
            }
        }
    };
}
