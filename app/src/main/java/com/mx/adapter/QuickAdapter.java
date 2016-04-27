package com.mx.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.R;
import com.mx.data.DataServer;
import com.mx.entity.Status;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class QuickAdapter extends BaseQuickAdapter<Status> {

    public QuickAdapter(Context context) {
        super(context, R.layout.tweet, DataServer.getSampleData(100));
    }

    public QuickAdapter(Context context,int dataSize) {
        super(context, R.layout.tweet,DataServer.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {

        helper.setText(R.id.tweetName,item.getUserName())
                .setText(R.id.tweetText,item.getText())
                .setText(R.id.tweetDate,item.getCreatedAt())
                .setImageUrl(R.id.tweetAvatar,item.getUserAvatar())
                .setVisible(R.id.tweetRT,item.isRetweet())
                .linkify(R.id.tweetText);
    }
}
