package com.example.administrator.bwft3.ui.store;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.entity.DataBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/13.
 */

public class RushAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<DataBean> list;
    private LayoutInflater inflater;
    private Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524459961&di=1f75ac9faacf8d369462c0a66e951479&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F110725%2F2893-110H5120H618.jpg");

    public RushAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_rush,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.shop_name.setText(dataBean.getTitle());
        myViewHolder.price.setText(dataBean.getContent());
        myViewHolder.rush_img.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView rush_img;
        private final TextView shop_name;
        private final TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            rush_img = itemView.findViewById(R.id.rush_img);
            shop_name = itemView.findViewById(R.id.shop_name);
            price = itemView.findViewById(R.id.now_price);

        }



    }


}
