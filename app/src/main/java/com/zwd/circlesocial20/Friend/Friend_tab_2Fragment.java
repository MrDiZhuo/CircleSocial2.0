package com.zwd.circlesocial20.Friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.SampleAdapter_1;
import com.zwd.circlesocial20.adapter.SampleAdapter_2;

import butterknife.Bind;
import io.rong.imkit.RongIM;


public class Friend_tab_2Fragment extends BaseFragment {
    @Bind(R.id.friend_sample_list_1)
    FloatingGroupExpandableListView list_1;

    @Bind(R.id.friend_sample_list_2)
    FloatingGroupExpandableListView list_2;

    SampleAdapter_1 adapter_1;

    WrapperExpandableListAdapter wrapperAdapter;

    SampleAdapter_2 adapter_2;

    WrapperExpandableListAdapter wrapperAdapter_2;

    protected int getContentViewID() {
        return R.layout.fragment_friend_tab_2;
    }

    @Override
    protected void initViews(View rootView) {
        final Context mContext;
        mContext = getContext();
        adapter_1 = new SampleAdapter_1(mContext);
        wrapperAdapter = new WrapperExpandableListAdapter(adapter_1);
        list_1.setGroupIndicator(null);
        list_1.setAdapter(wrapperAdapter);
        for(int i = 0; i < wrapperAdapter.getGroupCount(); i++) {
            list_1.expandGroup(i);
            list_1.collapseGroup(i);
        }

        list_1.setOnScrollFloatingGroupListener(new FloatingGroupExpandableListView.OnScrollFloatingGroupListener() {

            @Override
            public void onScrollFloatingGroupListener(View floatingGroupView, int scrollY) {
                float interpolation = -scrollY / (float) floatingGroupView.getHeight();
            }
        });

        list_1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                RongIM.getInstance().startPrivateChat(mContext,"2462","hello");
                return true;
            }
        });


        adapter_2 = new SampleAdapter_2(mContext);
        wrapperAdapter_2 = new WrapperExpandableListAdapter(adapter_2);
        list_2.setGroupIndicator(null);
        list_2.setAdapter(wrapperAdapter_2);
        for(int i = 0; i < wrapperAdapter_2.getGroupCount(); i++) {
            list_2.expandGroup(i);
            list_2.collapseGroup(i);
        }

        list_2.setOnScrollFloatingGroupListener(new FloatingGroupExpandableListView.OnScrollFloatingGroupListener() {

            @Override
            public void onScrollFloatingGroupListener(View floatingGroupView, int scrollY) {
                float interpolation = -scrollY / (float) floatingGroupView.getHeight();
            }
        });

        list_2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                RongIM.getInstance().startPrivateChat(mContext,"2462","hello");
                return true;
            }
        });

    }





    }


