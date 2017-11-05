package com.zwd.circlesocial20.ViewPager;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Me.Me_Discount;
import com.zwd.circlesocial20.Me.Me_Property;
import com.zwd.circlesocial20.Me.Me_info;
import com.zwd.circlesocial20.Party.MyParty;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.ListViewAdapter;
import com.zwd.circlesocial20.adapter.MeAdapter;
import com.zwd.circlesocial20.util.CircleImageView;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by asus-pc on 2016/12/9.
 */

public class MeFragment extends BaseFragment {
    @Bind(R.id.me_actionbar)
    BackActionBar action;
    @Bind(R.id.me_tool)
    RelativeLayout tool;
    @Bind(R.id.me_head)
    CircleImageView head;
    @Bind(R.id.me_name)
    TextView name;
    @Bind(R.id.me_list)
    ListView list;

    ArrayList<String> me;
    protected int getContentViewID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews(View rootView) {
        final Context mContext;
        mContext = getContext();
        initActionBar(action);
        me = getList();
        list.setAdapter(new MeAdapter(mContext,me));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(mContext,"第一个",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        goActivity(MyParty.class);
                        break;
                    case 2:
                        break;
                    case 3:
                        goActivity(Me_Property.class);
                        break;
                    case 4:
                        break;
                    case 5:
                        goActivity(Me_Discount.class);
                        break;
                    case 6:
                        break;
                }
            }
        });

    }

    @OnClick(R.id.me_tool)
    public void click(View v){
        switch (v.getId()){
            case R.id.me_tool:
                goActivity(Me_info.class);
                break;
        }
    }



    private void initActionBar(BackActionBar action) {
        action.hideBack();
        action.hidesubTitle();
        action.hideCustomButton();
        action.setTitle("我的");
    }

    public ArrayList<String> getList() {
        ArrayList<String> list =new ArrayList<>();
        list.add("我的圈子");
        list.add("我的聚会");
        list.add("我的消息");
        list.add("个人账户");
        list.add("兴趣标签");
        list.add("优惠券");
        list.add("设置");
        return list;
    }
}
