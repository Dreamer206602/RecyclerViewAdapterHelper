package com.mx.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.R;
import com.mx.entity.HomeItem;

import java.util.List;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class HomeAdapter extends BaseQuickAdapter<HomeItem> {
    public HomeAdapter(Context context, int layoutResId, List<HomeItem> data) {
        super(context, layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.info_text,item.getTitle());

    }
}
