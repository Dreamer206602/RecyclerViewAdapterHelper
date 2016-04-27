package com.mx.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class MultipleItem extends MultiItemEntity {
    public static final int TEXT=1;
    public static final int IMG=2;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
