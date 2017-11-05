package com.zwd.circlesocial20.ViewPager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Base.BaseAppManager;
import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.MainViewpager;
import com.zwd.circlesocial20.adapter.MyViewPagerAdapter;
import com.zwd.circlesocial20.util.ToastUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class TabMain extends BaseActivity implements ViewPager.OnPageChangeListener {
    private static final int TAB_1 = 0;
    private static final int TAB_2 = 1;
    private static final int TAB_3 = 2;
    private static final int TAB_4 = 3;
    private long exitTime = 0;

    @Bind(R.id.tab_viewpager)
    MainViewpager viewpager;
    @Bind(R.id.tab_1)
    ImageView tab_1;
    @Bind(R.id.tab_2)
    ImageView tab_2;
    @Bind(R.id.tab_3)
    ImageView tab_3;
    @Bind(R.id.tab_4)
    ImageView tab_4;
    @Bind(R.id.text_1)
    TextView text_1;
    @Bind(R.id.text_2)
    TextView text_2;
    @Bind(R.id.text_3)
    TextView text_3;
    @Bind(R.id.text_4)
    TextView text_4;
    @Bind(R.id.tab_party)
    RelativeLayout tab_party;
    @Bind(R.id.tab_circle)
    RelativeLayout tab_circle;
    @Bind(R.id.tab_friend)
    RelativeLayout tab_friend;
    @Bind(R.id.tab_me)
    RelativeLayout tab_me;

    private ArrayList<BaseFragment> fgms;

    protected int getContentView(){
        return R.layout.activity_tab_main;
    }

    protected void initViews() {
        fgms = new ArrayList<>();

        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
            RongIM.init(this);
        }
        String token = "1B2acYb84brZZ4PfUzMIQGPDVLoU3UWV3mx6WadUqtpbgr/gTvm/Uy8j5ivBjVlxmkhsQlKDK9cVBqtzAc9daYK7Se+O6Hq/";
        connect(token);

        BaseFragment mTab_01 = new PartyFragment();
        BaseFragment mTab_02 = new CircleFragment();
        BaseFragment mTab_03 = new FriendFragment();
        BaseFragment mTab_04 = new MeFragment();

        fgms.add(mTab_01);
        fgms.add(mTab_02);
        fgms.add(mTab_03);
        fgms.add(mTab_04);


        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(),fgms);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(this);
        viewpager.setOffscreenPageLimit(4);
        selectPage(TAB_1);
    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
    private void connect(String token) {
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())))
        {
            RongIM.connect(token, new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {
                    Log.d("wtt", "--onTokenIncorrect");
                }

                @Override
                public void onSuccess(String userid) {
                    Log.d("wtt", "--onSuccess" + userid);
                }
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.d("wtt", "--onError" + errorCode);
                }
            });
        }
    }

    private void selectPage(int page) {
        replaceFragments();
        switch (page) {
            case TAB_1:
                tab_1.setImageResource(R.mipmap.party_after);
                text_1.setTextColor(this.getResources().getColor(R.color.tab_after));
                viewpager.setCurrentItem(page);
                break;
            case TAB_2:
                tab_2.setImageResource(R.mipmap.circle_after);
                text_2.setTextColor(this.getResources().getColor(R.color.tab_after));
                viewpager.setCurrentItem(page);
                break;
            case TAB_3:
                tab_3.setImageResource(R.mipmap.friend_after);
                text_3.setTextColor(this.getResources().getColor(R.color.tab_after));
                viewpager.setCurrentItem(page);
                break;
            case TAB_4:
                tab_4.setImageResource(R.mipmap.me_after);
                text_4.setTextColor(this.getResources().getColor(R.color.tab_after));
                viewpager.setCurrentItem(page);
                break;

        }
    }

    /**
     * 充值图片样式
     */
    private void replaceFragments() {
        tab_1.setImageResource(R.mipmap.party_before);
        tab_2.setImageResource(R.mipmap.circle_brfore);
        tab_3.setImageResource(R.mipmap.friend_before);
        tab_4.setImageResource(R.mipmap.me_before);
        text_1.setTextColor(this.getResources().getColor(R.color.tab_before));
        text_2.setTextColor(this.getResources().getColor(R.color.tab_before));
        text_3.setTextColor(this.getResources().getColor(R.color.tab_before));
        text_4.setTextColor(this.getResources().getColor(R.color.tab_before));
    }


    @OnClick({R.id.tab_party,R.id.tab_circle,R.id.tab_friend,R.id.tab_me})
    public void onPageClick(View v){
        switch (v.getId()){
            case R.id.tab_party:
                selectPage(TAB_1);
                break;
            case R.id.tab_circle:
                selectPage(TAB_2);
                break;
            case R.id.tab_friend:
                selectPage(TAB_3);
                break;
            case R.id.tab_me:
                selectPage(TAB_4);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {
        selectPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 按两次BACK键退出程序
     *
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
