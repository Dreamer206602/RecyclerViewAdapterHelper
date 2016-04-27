package com.mx.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.chad.library.adapter.base.animation.BaseAnimation;

/**
 * Created by boobooL on 2016/4/27 0027
 * Created 邮箱 ：boobooMX@163.com
 */
public class CustomAnimation extends BaseAnimation{
    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view,"scaleY",1,1.1f,1),
                ObjectAnimator.ofFloat(view,"scaleX",1,1.1f,1)

        };
    }
}
