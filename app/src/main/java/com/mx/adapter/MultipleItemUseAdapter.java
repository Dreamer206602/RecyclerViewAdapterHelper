package com.mx.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.entity.MultipleItem;
import com.mx.R;

import java.util.List;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class MultipleItemUseAdapter extends BaseMultiItemQuickAdapter<MultipleItem> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context The context.
     * @param data    A new list is created out of this one to avoid mutable list
     */
    public MultipleItemUseAdapter(Context context, List data) {
        super(context, data);
        addItmeType(MultipleItem.TEXT, R.layout.text_view);
        addItmeType(MultipleItem.IMG, R.layout.image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (item.getItemType()){
            case MultipleItem.TEXT:
                helper.setImageUrl(R.id.tv,item.getContent());
                break;
            case MultipleItem.IMG:
                helper.setImageUrl(R.id.tv,item.getContent());
                break;
        }
    }
}
