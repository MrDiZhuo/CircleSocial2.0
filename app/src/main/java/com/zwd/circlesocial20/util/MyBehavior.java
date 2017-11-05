package com.zwd.circlesocial20.util;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

//////////////上推出现，下拉消失//////

/**
 * Created by asus-pc on 2016/10/15.
 */

public class MyBehavior extends CoordinatorLayout.Behavior{
    /////必须实现，否则不能用第二种方式///
    public MyBehavior(Context context , AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if(dy < 0){
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }else{
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }
    }
}
