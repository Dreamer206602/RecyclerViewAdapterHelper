package com.mx;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.adapter.QuickAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HeaderAndFooterActivity extends AppCompatActivity {

    @InjectView(R.id.rv_list)
    RecyclerView mRvList;
    private QuickAdapter mAdapter;
    public static final int PAGE_SIZE=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_and_footer);
        ButterKnife.inject(this);
       // mRvList.setHasFixedSize(true);
        initAdapter();

        mAdapter.addHeaderView(getView());
        mAdapter.addFooterView(getView());
        mRvList.setAdapter(mAdapter);

    }

    private View getView() {
        View view=getLayoutInflater().inflate(R.layout.head_view,null);
        view.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HeaderAndFooterActivity.this,"click View",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initAdapter() {
        mAdapter=new QuickAdapter(this,PAGE_SIZE);
        mAdapter.openLoadAnimation();
        mRvList.setAdapter(mAdapter);
        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(HeaderAndFooterActivity.this,""+ Integer.toString(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
