package com.zwd.circlesocial20.Party;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Base.BasePopupWindow;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;

import butterknife.Bind;
import butterknife.OnClick;

import static com.zwd.circlesocial20.util.dip2pxUtils.dip2px;

public class Party_list extends BaseActivity {
    @Bind(R.id.party_list_actionbar)
    BackActionBar action;
    @Bind(R.id.party_list_img)
    ImageView img;
    @Bind(R.id.party_list_theme)
    TextView theme;
    @Bind(R.id.party_list_avry)
    TextView avry;
    @Bind(R.id.party_list_title)
    TextView title;
    @Bind(R.id.party_list_num)
    TextView num;
    @Bind(R.id.party_list_locate)
    TextView locate;
    @Bind(R.id.party_list_money)
    TextView money;
    @Bind(R.id.party_list_time)
    TextView time;
    @Bind(R.id.party_list_intro)
    TextView intro;
    @Bind(R.id.party_list_share)
    Button share;
    @Bind(R.id.party_list_attend)
    Button attend;

    private Bundle bundle;
    private BasePopupWindow mPopupWindow;
    View popupwindow;

    @Override
    protected int getContentView() {
        return R.layout.activity_party_list;
    }
    @Override
    protected void initViews() {
        initActionBar(action);
        popupwindow = getLayoutInflater().inflate(R.layout.pop_party_share,null);
        mPopupWindow = new BasePopupWindow(this);
        mPopupWindow.setAnimationStyle(R.style.newparty_anim_style);
        mPopupWindow.setContentView(popupwindow);
        mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
    }


    private void initActionBar(BackActionBar action) {
        action.hidesubTitle();
        action.hideCustomButton();
        action.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        action.setTitle("聚会详情");
    }

    @OnClick({R.id.party_list_share,R.id.party_list_attend})
    public void click(View view){
        switch (view.getId()){
            case R.id.party_list_attend:
                break;
            case R.id.party_list_share:
                mPopupWindow.showAtLocation(Party_list.this.findViewById(R.id.party_list_share), Gravity.BOTTOM,0,0);
                break;
        }
    }
}
