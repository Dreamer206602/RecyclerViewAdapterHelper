package com.mx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.mx.adapter.MultipleItemUseAdapter;
import com.mx.data.DataServer;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MultipleItemUseActivity extends AppCompatActivity {

    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private MultipleItemUseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        ButterKnife.inject(this);
        mAdapter=new MultipleItemUseAdapter(this, DataServer.getMultipleItemData());
        mRecyclerView.setAdapter(mAdapter);
    }
}
