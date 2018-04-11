package com.example.administrator.bwft3.ui.register;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.bwft3.R;

/**
 * Created by Administrator on 2018/4/11.
 */

public class PopupwindowUtil {
    private PopupWindow popupWindow;
    private int width;
    private WindowManager.LayoutParams lp;
    private Window window;
    private TextView pop_title;
    private TextView pop_message;
    private TextView but_register_pop;


    public PopupwindowUtil() {
    }

    public void setPop(Activity context, String title, String message) {
        window = context.getWindow();
        View view1 = LayoutInflater.from(context).inflate(R.layout.popuplayout, null);
        but_register_pop = view1.findViewById(R.id.but_register_pop);
        pop_title = view1.findViewById(R.id.pop_title);
        pop_message = view1.findViewById(R.id.pop_message);
        pop_title.setText(title);
        pop_message.setText(message);
        view1.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shapepopwindow));
        popupWindow = new PopupWindow();
        popupWindow.setFocusable(true);
        lp = window.getAttributes();
        popupWindow.setOutsideTouchable(true);
        lp.alpha = 0.7f;
        window.setAttributes(lp);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setContentView(view1);//获取到的布局
        popupWindow.setHeight(300);
        width = context.getWindowManager().getDefaultDisplay().getWidth();
        int i = (int) (width * 0.8);
        popupWindow.setWidth(i);

        popupWindow.showAtLocation(view1, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(mDismissListener);
        but_register_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();

            }
        });
    }

    private PopupWindow.OnDismissListener mDismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            lp.alpha = 1.0f;
            window.setAttributes(lp);
        }

    };
}
