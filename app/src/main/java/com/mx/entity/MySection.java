package com.mx.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class MySection extends SectionEntity<Video> {
    private boolean isMore;
    public MySection(boolean isHeader, String header,boolean isMore) {
        super(isHeader, header);
        this.isMore=isMore;
    }
    public MySection(Video t){
        super(t);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
