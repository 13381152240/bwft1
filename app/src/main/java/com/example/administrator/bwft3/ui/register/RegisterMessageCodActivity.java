package com.example.administrator.bwft3.ui.register;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bwft3.R;

public class RegisterMessageCodActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_title;
    private TextView tv_registerPhoneMessageCode;
    private EditText ed_PhoneMessageCode;
    private TextView but_sendCodeAgain;
    private EditText ed_RefereePhoneNumber;
    private Button but_stepTwo;
    private TextView tv_registerAgreementTwo;
    private Handler handler = new Handler();
    int i = 120;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i--;
//            Log.e("aaa","i:"+i);
            if (i == 0) {
                but_sendCodeAgain.setEnabled(true);
//                but_sendCodeAgain.setBackgroundColor(Color.parseColor("#e60012"));
                but_sendCodeAgain.setText("发送验证码");
            } else {
                but_sendCodeAgain.setEnabled(false);
                handler.postDelayed(runnable, 1000);
                but_sendCodeAgain.setText("重新发送（" + i + ")");
            }
        }
    };
    private ImageView title_return;
    private String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_message_cod);
        initView();
        initData();

//        CountDownTimer(long millisInFuture, long countDownInterval)
    }

    private void initData() {
        Intent intent = getIntent();
        phonenumber = intent.getStringExtra("phonenumber");
        tv_registerPhoneMessageCode.setText("请输入" + phonenumber + "收到的验证码");

        handler.postDelayed(runnable, 0);
        but_sendCodeAgain.setText("重新发送（120）");
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_registerPhoneMessageCode = (TextView) findViewById(R.id.tv_registerPhoneMessageCode);
        ed_PhoneMessageCode = (EditText) findViewById(R.id.ed_PhoneMessageCode);
        ed_PhoneMessageCode.addTextChangedListener(editclick);
        ed_PhoneMessageCode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        but_sendCodeAgain = (TextView) findViewById(R.id.but_sendCodeAgain);
        ed_RefereePhoneNumber = (EditText) findViewById(R.id.ed_RefereePhoneNumber);
        ed_RefereePhoneNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        but_stepTwo = (Button) findViewById(R.id.but_stepTwo);
        tv_registerAgreementTwo = (TextView) findViewById(R.id.tv_registerAgreementTwo);

        tv_registerAgreementTwo.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_registerAgreementTwo.getPaint().setAntiAlias(true);//抗锯齿

        but_sendCodeAgain.setOnClickListener(this);
        but_stepTwo.setOnClickListener(this);
        title_return = (ImageView) findViewById(R.id.title_return);
        title_return.setOnClickListener(this);
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
            String Messagecode = ed_PhoneMessageCode.getText().toString();
            if (Messagecode.length() == 4) {
                but_stepTwo.setEnabled(true);
//                but_stepTwo.setBackgroundColor(Color.parseColor("#e60012"));
                but_stepTwo.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));

            } else {
                but_stepTwo.setEnabled(false);
//                but_stepTwo.setBackgroundColor(Color.parseColor("#e0e0e0"));

                but_stepTwo.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));

            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_sendCodeAgain:
                i = 120;
                handler.postDelayed(runnable, 1000);
                break;
            case R.id.but_stepTwo:
                String s = ed_RefereePhoneNumber.getText().toString();
                String ss = ed_PhoneMessageCode.getText().toString();
                if (s.length() == 11 || s.length() == 0) {
                    Intent intent = new Intent(RegisterMessageCodActivity.this, RegisterPassWordActivity.class);
                    intent.putExtra("phone",phonenumber);
                    intent.putExtra("code",ss);
                    intent.putExtra("tuijian",s);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "推荐人手机号有误请重新确认", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.title_return:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String PhoneMessageCode = ed_PhoneMessageCode.getText().toString().trim();
        if (TextUtils.isEmpty(PhoneMessageCode)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String RefereePhoneNumber = ed_RefereePhoneNumber.getText().toString().trim();
        if (TextUtils.isEmpty(RefereePhoneNumber)) {
            Toast.makeText(this, "推荐人手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}