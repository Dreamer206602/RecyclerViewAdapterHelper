package com.mx;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.adapter.QuickAdapter;
import com.mx.data.DataServer;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PullToRefreshActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.rv_list)
    RecyclerView mRvList;
    @InjectView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;

    private QuickAdapter mQuickAdapter;
    public static final int TOTAL_COUNTER = 30;
    public static final int PAGE_SIZE = 10;
    private int delayMillis = 1000;
    private int mCurrentCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);
        ButterKnife.inject(this);
        mSwipeLayout.setColorSchemeColors(Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED);

        initAdapter();
        addHeadView();

        mSwipeLayout.setOnRefreshListener(this);

    }

    private void initAdapter() {
        mQuickAdapter = new QuickAdapter(this, PAGE_SIZE);
        mQuickAdapter.openLoadAnimation();
        mRvList.setAdapter(mQuickAdapter);
        mCurrentCounter = mQuickAdapter.getItemCount();
        mQuickAdapter.setOnLoadMoreListener(PAGE_SIZE, this);
        addHeadView();
        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(PullToRefreshActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addHeadView() {
        View view = getLayoutInflater().inflate(R.layout.head_view, null);
        view.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PullToRefreshActivity.this, "click HeadView", Toast.LENGTH_SHORT).show();
            }
        });
        mQuickAdapter.addHeaderView(view);
    }

    @Override
    public void onLoadMoreRequested() {
        //上拉加载的时候，设置SwipeRefreshLayout禁止刷新
        mSwipeLayout.setRefreshing(false);
        if (mCurrentCounter >= TOTAL_COUNTER) {
            mRvList.post(new Runnable() {
                @Override
                public void run() {
                    mQuickAdapter.isNextLoad(false);
                }
            });

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DataServer.addData(mQuickAdapter.getData(), PAGE_SIZE);
                    mCurrentCounter = mQuickAdapter.getItemCount();
                    mQuickAdapter.isNextLoad(true);

                }
            }, delayMillis);
        }
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DataServer.addData(mQuickAdapter.getData(), PAGE_SIZE);
                mQuickAdapter.notifyDataSetChanged();
            }
        }, delayMillis);
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, delayMillis * 2);

    }

    public static final int REFRESH_COMPLETE = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeLayout.setRefreshing(false);
                    break;
            }
        }
    };
}
