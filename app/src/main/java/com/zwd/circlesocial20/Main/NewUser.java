package com.zwd.circlesocial20.Main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;

import butterknife.Bind;
import butterknife.OnClick;

public class NewUser extends BaseActivity {
    @Bind(R.id.new_user_actionbar)
    BackActionBar actionbar;
    @Bind(R.id.new_user_phone)
    EditText phone;
    @Bind(R.id.new_user_pwd)
    EditText pwd;
    @Bind(R.id.new_user_vertification)
    EditText vertification;
    @Bind(R.id.new_user_get)
    Button get;
    @Bind(R.id.new_user_yes)
    Button yes;



    @Override
    protected int getContentView() {
        return R.layout.activity_new_user;
    }
    @Override
    protected void initViews() {
        initActionBar(actionbar);
    }

    private void initActionBar(BackActionBar actionbar) {
        actionbar.hidesubTitle();
        actionbar.hideCustomButton();
        actionbar.setTitle("忘记密码");
        actionbar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @OnClick({R.id.new_user_get,R.id.new_user_yes})
    public void click(View v){
        switch (v.getId()){
            case R.id.new_user_get:
                break;
            case R.id.new_user_yes:
                break;
        }
    }



    /**
     *键盘返回
     */
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return true;
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
