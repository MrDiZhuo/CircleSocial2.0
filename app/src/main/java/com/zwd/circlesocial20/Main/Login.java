package com.zwd.circlesocial20.Main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Base.BaseAppManager;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.ViewPager.TabMain;
import com.zwd.circlesocial20.util.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class Login extends BaseActivity {
    @Bind(R.id.login_image)
    ImageView image;
    @Bind(R.id.login_phone)
    EditText phone;

    @Bind(R.id.login_pwd)
    EditText pwd;
    @Bind(R.id.login_yes)
    Button yes;
    @Bind(R.id.login_forget)
    TextView forget;
    @Bind(R.id.login_new)
    TextView newuse;

    private long exitTime = 0;


    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }
    @Override
    protected void initViews(){


        /**
         * 屏幕大小
         */
        WindowManager wm = (WindowManager) getBaseContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        double het = (double) width * 0.7;
        image.setImageResource(R.mipmap.login_background);
        image.setMaxWidth(WindowManager.LayoutParams.MATCH_PARENT);
        image.setMaxHeight((int)het);
        image.setScaleType(ImageView.ScaleType.FIT_START);


    }

    @OnClick({R.id.login_yes,R.id.login_forget,R.id.login_new})
    public void click(View v){
        switch (v.getId()){
            case R.id.login_yes:
                goActivity(TabMain.class);
                break;
            case R.id.login_forget:
                goActivity(forgetpwd.class);
                break;
            case R.id.login_new:
                goActivity(NewUser.class);
                break;
        }
    }




    /**
     * 按两次BACK键退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showShort(this, getString(R.string.text_one_more_click));
                exitTime = System.currentTimeMillis();
            } else {
                BaseAppManager.getInstance().clearAll();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
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
