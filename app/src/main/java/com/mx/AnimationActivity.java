package com.mx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mx.adapter.QuickAdapter;
import com.mx.animation.CustomAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AnimationActivity extends AppCompatActivity {

    @InjectView(R.id.spinner)
    MaterialSpinner mSpinner;
    @InjectView(R.id.spinner_first_only)
    MaterialSpinner mSpinnerFirstOnly;
    @InjectView(R.id.rv_list)
    RecyclerView mRvList;
    private QuickAdapter mQuickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.inject(this);
        mRvList.setHasFixedSize(true);
        initAdapter();
        initMenu();

    }

    private void initAdapter() {
        mQuickAdapter = new QuickAdapter(this);
        mQuickAdapter.openLoadAnimation();
        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(AnimationActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
        mRvList.setAdapter(mQuickAdapter);

    }

    private void initMenu() {
        mSpinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom");
        mSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position) {
                    case 0:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        break;
                    case 1:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        break;
                    case 2:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                        break;
                    case 3:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                        break;
                    case 4:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                        break;
                    case 5:
                        mQuickAdapter.openLoadAnimation(new CustomAnimation());
                        break;
                }
                mRvList.setAdapter(mQuickAdapter);
            }
        });


        mSpinnerFirstOnly.setItems("isFirstOnly(true)","isFirstOnly(false)");
        mSpinnerFirstOnly.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position){
                    case 0:
                        mQuickAdapter.isFirstOnly(true);
                        break;
                    case 1:
                        mQuickAdapter.isFirstOnly(false);
                        break;
                }

                mQuickAdapter.notifyDataSetChanged();
            }
        });

    }
}
