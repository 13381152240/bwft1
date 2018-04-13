package com.example.administrator.bwft3.ui.store;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.bwft3.ImageLoder.ImageHelper;
import com.example.administrator.bwft3.R;
import com.example.administrator.bwft3.entity.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/11.
 */

public class Storefragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.bann)
    ImageView bann;
    private String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523600024281&di=c052d78f0e2d87765d4c67885073e8ff&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F00%2F03%2F32%2F61568a71b4a554e.jpg";
    private RecyclerView rlv_rush;
    private RushAdapter rushAdapter = null;
    private List<DataBean> dataList;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView(view);
        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageHelper imageHelper = new ImageHelper(getActivity());
        imageHelper.display(bann, url1);
        dataList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            DataBean data = new DataBean("叶应是叶", "我也不知道说什么好，我也不知道说什么好，我也不知道说什么好，我也不知道说什么好");
            dataList.add(data);
        }
        rlv_rush.setLayoutManager(new LinearLayoutManager(getActivity()));
        rushAdapter = new RushAdapter(getActivity(),dataList);
        Log.e("aaa",dataList.size()+"");
        rlv_rush.setAdapter(rushAdapter);
        //解决RecyclerView的滑动冲突
        rlv_rush.setNestedScrollingEnabled(false);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initView(View view) {

        rlv_rush = (RecyclerView) view.findViewById(R.id.rlv_rush);


    }
}
