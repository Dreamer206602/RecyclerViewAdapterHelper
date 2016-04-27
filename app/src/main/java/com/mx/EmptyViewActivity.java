package com.mx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mx.adapter.QuickAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class EmptyViewActivity extends AppCompatActivity {

    @InjectView(R.id.rv_list)
    RecyclerView mRvList;
    private QuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_view);
        ButterKnife.inject(this);

        mRvList.setHasFixedSize(true);


        mAdapter = new QuickAdapter(this, 0);
        View emptyView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRvList.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mRvList.setAdapter(mAdapter);


    }
}
