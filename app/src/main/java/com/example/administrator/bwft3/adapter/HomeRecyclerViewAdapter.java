package com.example.administrator.bwft3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyHolder> {
    private Context context;
    private List<Object> list;

    public HomeRecyclerViewAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }
    /**
     * recyclerView 加载多布局方法步骤
     * 1. 建两个不同的布局
     * 2. 思路：要提供一个不同的标准，标注  程序选择不同的布局
     */
    @Override
    public int getItemViewType(int position) {
//        return list.get(position).getName().contains("2")==true?0:1;
        return 0;
    }
    /**
     * 实例化一个布局
     * @param parent
     * @param viewType <----getItemviewType
     * @return
     */
    @Override
    public HomeRecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder = null;
        switch (viewType){
            case 0:
//                View inflate = LayoutInflater.from(context).inflate(R.layout.layout, null);
//                myHolder = new MyHolder(inflate);
                break;
            case 1:
//                View inflate1 = LayoutInflater.from(context).inflate(R.layout.layout1, null);
//                myHolder = new MyHolder(inflate1);
                break;
        }
        return myHolder;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewAdapter.MyHolder holder, int position) {
//        holder.img.setImageResource(list.get(position).getImg());
//        holder.name.setText(list.get(position).getName());
//        holder.text.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 各种布局，进行重用的view
     */
    public class MyHolder extends RecyclerView.ViewHolder {
//        private final ImageView img;
//        private final TextView name;
//        private final TextView text;
        public MyHolder(View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.img);
//            name = itemView.findViewById(R.id.name);
//            text = itemView.findViewById(R.id.text);
        }
    }
}
