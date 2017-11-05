package com.zwd.circlesocial20.Me;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Party.MyParty;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.MeAdapter;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;

import butterknife.Bind;

public class Me_Property extends BaseActivity {
    @Bind(R.id.me_property_action)
    BackActionBar action;
    @Bind(R.id.me_property_money)
    TextView money;
    @Bind(R.id.me_property_list)
    ListView list;

    ArrayList<String> me;

    protected int getContentView(){
        return R.layout.activity_me__property;
    }

    protected void initViews() {
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
                        Toast.makeText(mContext,"第二个",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

    }

    private void initActionBar(BackActionBar action) {
        action.hidesubTitle();
        action.hideCustomButton();
        action.setTitle("个人账户");
        action.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public ArrayList<String> getList() {
        ArrayList<String> list =new ArrayList<>();
        list.add("退款售后");
        list.add("申诉支持");
        list.add("活动支付");
        list.add("账户充值");
        return list;
    }

}
