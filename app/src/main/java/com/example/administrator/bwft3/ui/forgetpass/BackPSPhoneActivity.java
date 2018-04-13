package com.example.administrator.bwft3.ui.forgetpass;

import android.content.Intent;
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
import com.example.administrator.bwft3.ui.MainActivity;
import com.vondear.rxtools.RxActivityTool;

public class BackPSPhoneActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView title_return;
    private TextView tv_title;
    private EditText ed_phonenumber_backphone;
    private EditText ed_backphonenumbercode;
    private Button but_backphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_psphone);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        ed_phonenumber_backphone.addTextChangedListener(editclick);
        ed_backphonenumbercode.addTextChangedListener(editclick);

        title_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxActivityTool.skipActivity(BackPSPhoneActivity.this,MainActivity.class);
            }
        });
    }

    private void initData() {
        tv_title.setText("找回密码");
    }

    private void initView() {
        title_return = (ImageView) findViewById(R.id.title_return);
        tv_title = (TextView) findViewById(R.id.tv_title);
        ed_phonenumber_backphone = (EditText) findViewById(R.id.ed_phonenumber_backphone);
        ed_backphonenumbercode = (EditText) findViewById(R.id.ed_backphonenumbercode);
        but_backphone = (Button) findViewById(R.id.but_backphone);
        ed_backphonenumbercode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ed_phonenumber_backphone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        but_backphone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_backphone:
                Intent intent=new Intent(this, BackPSActivity.class);
                intent.putExtra("phonenumber",ed_phonenumber_backphone.getText().toString());
                startActivity(intent);
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
            String phonenumber = ed_phonenumber_backphone.getText().toString();
            String numbercode = ed_backphonenumbercode.getText().toString();
            if (phonenumber.length() == 11 && numbercode.length() == 4) {
                but_backphone.setEnabled(true);
                but_backphone.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapered));
//                but_step.setBackgroundColor(Color.parseColor("#e60012"));
            } else {
                but_backphone.setEnabled(false);
                but_backphone.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshapegray));
//                but_step.setBackgroundColor(Color.parseColor("#e0e0e0"));
            }
        }
    };
}
