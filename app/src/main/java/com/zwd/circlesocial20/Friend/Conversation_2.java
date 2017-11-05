package com.zwd.circlesocial20.Friend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;

import butterknife.Bind;

public class Conversation_2 extends BaseActivity {
    @Bind(R.id.conversation_actionbar)
    BackActionBar actionBar;
    @Override
    protected int getContentView() {
        return R.layout.activity_conversation_2;
    }
    @Override
    protected void initViews(){
        initActionBar(actionBar);

    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        actionBar.setTitle("联系人");
        actionBar.hideCustomButton();
        actionBar.hidesubTitle();
    }

    /**
     * 点击键盘以外的区域隐藏键盘
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        if(ev.getAction() ==MotionEvent.ACTION_DOWN){
            View v =getCurrentFocus();
            if(isShoudHideKeyBoard(v,ev)){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm!=null){
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        if(getWindow().superDispatchTouchEvent(ev)){
            return true;
        }
        return onTouchEvent(ev);
    }
    private boolean isShoudHideKeyBoard(View v, MotionEvent event) {
        if(v!=null&&(v instanceof EditText)){
            int[] l = {0,0};
            v.getLocationInWindow(l);
            int left = l[0], top =l[1],bottom = top+v.getHeight(),right=left+v.getWidth();
            if(event.getX()>left && event.getX()<right &&event.getY()<bottom && event.getY()>top){
                return false;
            }else {
                return true;
            }
        }
        return false;

    }





}
