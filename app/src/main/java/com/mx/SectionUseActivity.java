package com.mx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.adapter.SectionAdapter;
import com.mx.data.DataServer;
import com.mx.entity.MySection;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SectionUseActivity extends AppCompatActivity implements BaseQuickAdapter.OnRecyclerViewItemClickListener {


    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private List<MySection> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_use);
        ButterKnife.inject(this);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mData = DataServer.getSampleData();
        SectionAdapter mAdapter = new SectionAdapter(this, R.layout.head_view, R.layout.def_section_head, mData);
        mAdapter.setOnRecyclerViewItemClickListener(this);
        //mRecyclerView.addItemDecoration(new GridItemDecoration(this,R.drawable.list_divider));
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onItemClick(View view, int position) {

        Toast.makeText(this, mData.get(position).t.getName(), Toast.LENGTH_SHORT).show();
    }
}
