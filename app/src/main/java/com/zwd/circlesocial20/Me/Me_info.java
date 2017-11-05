package com.zwd.circlesocial20.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Main.Login;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;

import butterknife.Bind;
import butterknife.OnClick;

public class Me_info extends BaseActivity {
    @Bind(R.id.me_info_actionbar)
    BackActionBar actionBar;
    @Bind(R.id.me_info_img)
    LinearLayout img;
    @Bind(R.id.me_info_name)
    LinearLayout name;
    @Bind(R.id.me_info_pwd)
    LinearLayout pwd;
    @Bind(R.id.me_info_out)
    TextView out;




    @Override
    protected int getContentView() {
        return R.layout.activity_me_info;
    }
    @Override
    protected void initViews(){
        initActionBar(actionBar);

    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.hidesubTitle();
        actionBar.hideCustomButton();
        actionBar.setTitle("修改信息");
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.me_info_out})
    public void click(View v){
        switch (v.getId()){
            case R.id.me_info_out:
                goActivity(Login.class);
                break;
        }
    }

}
