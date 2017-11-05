package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不能左右滑动
 */

public class MainViewpager extends ViewPager {

    public MainViewpager(Context context) {
        super(context);
    }

    public MainViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0){
       return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0){
        return false;
    }
}
