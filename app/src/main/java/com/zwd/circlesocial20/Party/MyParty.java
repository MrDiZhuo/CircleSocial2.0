package com.zwd.circlesocial20.Party;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Friend.Friend_tab_1Fragment;
import com.zwd.circlesocial20.Friend.Friend_tab_2Fragment;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.MyViewPagerAdapter;
import com.zwd.circlesocial20.adapter.ViewPagerAdapter;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;

import butterknife.Bind;

public class MyParty extends BaseActivity {
    @Bind(R.id.my_party_actionbar)
    BackActionBar actionBar;
    @Bind(R.id.my_party_tab)
    TabLayout tab;
    @Bind(R.id.my_party_viewpager)
    ViewPager viewPager;

    private ArrayList<BaseFragment> fgms;
    private ArrayList<String> mTitle;

    protected int getContentView(){
        return R.layout.activity_my_party;
    }

    protected void initViews() {
        initActionBar(actionBar);
        mTitle =new ArrayList<>();
        fgms = new ArrayList<>();
        mTitle.add("未开始");
        mTitle.add("已结束");
        mTitle.add("我发起的");
        BaseFragment mTab_01 = new MyParty_1Fragment();
        BaseFragment mTab_02 = new MyParty_2Fragment();
        BaseFragment mTab_03 = new MyParty_3Fragment();
        fgms.add(mTab_01);
        fgms.add(mTab_02);
        fgms.add(mTab_03);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(),mTitle,fgms);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tab.setupWithViewPager(viewPager);
        tab.setTabsFromPagerAdapter(adapter);

    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.setTitle("我的聚会");
        actionBar.hidesubTitle();
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        actionBar.setCustomButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(NewParty.class);
            }
        });
    }

}
