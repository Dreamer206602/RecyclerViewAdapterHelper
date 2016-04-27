package com.mx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.adapter.HomeAdapter;
import com.mx.entity.HomeItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private static final Class<?>[]ACTIVITY={AnimationActivity.class,MultipleItemUseActivity.class,
            HeaderAndFooterActivity.class,PullToRefreshActivity.class,
            SectionUseActivity.class,EmptyViewActivity.class};
    public static final String[] TITLE={"Animation Use","MultipleItem Use","HeaderAndFooter Use","PullToRefresh Use",
            "Section Use","EmptyView Use"};
    private ArrayList<HomeItem>mDataList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        BaseQuickAdapter homeAdapter=new HomeAdapter(this,R.layout.home_item_view,mDataList);
        homeAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(MainActivity.this,ACTIVITY[position]);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(homeAdapter);

    }

    private void initData() {
        mDataList=new ArrayList<>();
        for (int i = 0; i <TITLE.length ; i++) {
            HomeItem homeItem=new HomeItem();
            homeItem.setTitle(TITLE[i]);
            homeItem.setActivity(ACTIVITY[i]);
            mDataList.add(homeItem);
        }



    }
}
