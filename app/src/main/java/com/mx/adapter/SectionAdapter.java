package com.mx.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.R;
import com.mx.entity.MySection;
import com.mx.entity.Video;

import java.util.List;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context          The context.
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(Context context, int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(context, layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header,item.header);
        helper.setVisible(R.id.more,item.isMore());
        helper.setOnClickListener(R.id.more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,item.header+"more..",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        Video video=(Video) item.t;
        helper.setImageUrl(R.id.iv,video.getImg());
        helper.setText(R.id.tv,video.getName());

    }
}
