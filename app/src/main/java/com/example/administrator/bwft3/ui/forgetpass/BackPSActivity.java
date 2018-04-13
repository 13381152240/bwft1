package com.example.administrator.bwft3.ui.forgetpass;

import android.content.Intent;
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

public class BackPSActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView title_return;
    private TextView tv_title;
    private TextView backps_phonenumber;
    private EditText backps_PhoneMessageCode;
    private TextView backps_sendCodeAgain;
    private Button backps_step;
    private Handler handler = new Handler();
    int i = 120;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i--;
//            Log.e("aaa","i:"+i);
            if (i == 0) {
                backps_sendCodeAgain.setEnabled(true);
                backps_sendCodeAgain.setText("发送验证码");
            } else {
                backps_sendCodeAgain.setEnabled(false);
                backps_sendCodeAgain.setText("重新发送（" + i + ")");
                handler.postDelayed(runnable, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_ps);
        initView();
        initData();
    }

    private void initData() {
        tv_title.setText("找回密码");
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        backps_phonenumber.setText(number);

        handler.postDelayed(runnable, 0);
        backps_sendCodeAgain.setText("重新发送（120）");
    }

    private void initView() {
        title_return = (ImageView) findViewById(R.id.title_return);
        tv_title = (TextView) findViewById(R.id.tv_title);
        backps_phonenumber = (TextView) findViewById(R.id.backps_phonenumber);
        backps_PhoneMessageCode = (EditText) findViewById(R.id.backps_PhoneMessageCode);
        backps_PhoneMessageCode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        backps_PhoneMessageCode.addTextChangedListener(editclick);
        backps_sendCodeAgain = (TextView) findViewById(R.id.backps_sendCodeAgain);
        backps_step = (Button) findViewById(R.id.backps_step);

        backps_step.setOnClickListener(this);
        backps_sendCodeAgain.setOnClickListener(this);
        title_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backps_sendCodeAgain:
                i = 120;
                handler.postDelayed(runnable, 1000);
                break;
            case R.id.backps_step:
                Intent intent=new Intent(BackPSActivity.this,BackPSSetPSActivity.class);
                startActivity(intent);
                break;
            case R.id.title_return:
                finish();
                break;

        }
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
            String Messagecode = backps_PhoneMessageCode.getText().toString();
            if (Messagecode.length() == 4) {
                backps_step.setEnabled(true);
                backps_step.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));
            } else {
                backps_step.setEnabled(false);
                backps_step.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));

            }
        }
    };

    private void submit() {
        // validate
        String PhoneMessageCode = backps_PhoneMessageCode.getText().toString().trim();
        if (TextUtils.isEmpty(PhoneMessageCode)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}