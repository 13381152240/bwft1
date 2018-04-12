package com.example.administrator.bwft3.ui.register;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_registerphonenumbercode;
    private EditText ed_phonenumber;
    private EditText ed_numbercode;
    private Button but_step;
    private TextView tv_registerAgreement;
    private ImageView title_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initSetLogic();

    }

    private void initSetLogic() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_bussness_address_down);
        drawable.setBounds(0, 0, 40, 20);
        tv_registerphonenumbercode.setCompoundDrawables(null, null, drawable, null);
        ed_numbercode.addTextChangedListener(editclick);
        ed_phonenumber.addTextChangedListener(editclick);

        tv_registerAgreement.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_registerAgreement.getPaint().setAntiAlias(true);//抗锯齿
    }

    private void initView() {
        tv_registerphonenumbercode = (TextView) findViewById(R.id.tv_registerphonenumbercode);
        tv_registerphonenumbercode.setOnClickListener(this);
        ed_phonenumber = (EditText) findViewById(R.id.ed_phonenumber);
        ed_phonenumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        ed_phonenumber.setOnClickListener(this);
        ed_numbercode = (EditText) findViewById(R.id.ed_numbercode);
        ed_numbercode.setOnClickListener(this);
        ed_numbercode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        but_step = (Button) findViewById(R.id.but_step);
        but_step.setOnClickListener(this);
        tv_registerAgreement = (TextView) findViewById(R.id.tv_registerAgreement);
        tv_registerAgreement.setOnClickListener(this);
        title_return = (ImageView) findViewById(R.id.title_return);
        title_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_step:
                Intent intent = new Intent(RegisterActivity.this, RegisterMessageCodActivity.class);
                intent.putExtra("phonenumber", ed_phonenumber.getText().toString());
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
            String phonenumber = ed_phonenumber.getText().toString();
            String numbercode = ed_numbercode.getText().toString();
            if (phonenumber.length() == 11 && numbercode.length() == 4) {
                but_step.setEnabled(true);
                but_step.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));

//                but_step.setBackgroundColor(Color.parseColor("#e60012"));
            } else {
                but_step.setEnabled(false);
                but_step.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));

//                but_step.setBackgroundColor(Color.parseColor("#e0e0e0"));
            }
        }
    };

    private void submit() {
        // validate
        String phonenumber = ed_phonenumber.getText().toString().trim();
        if (TextUtils.isEmpty(phonenumber)) {
            Toast.makeText(this, "请输入您的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String numbercode = ed_numbercode.getText().toString().trim();
        if (TextUtils.isEmpty(numbercode)) {
            Toast.makeText(this, "请输入图片验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
