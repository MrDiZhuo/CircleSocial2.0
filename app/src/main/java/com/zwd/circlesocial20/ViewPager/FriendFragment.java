package com.zwd.circlesocial20.ViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Friend.Friend_tab_1Fragment;
import com.zwd.circlesocial20.Friend.Friend_tab_2Fragment;
import com.zwd.circlesocial20.R;

import butterknife.Bind;
import butterknife.OnClick;

public class FriendFragment extends BaseFragment {
    @Bind(R.id.friend_message)
    Button message;
    @Bind(R.id.friend_group)
    Button group;

    private Friend_tab_1Fragment messageFragment;
    private Friend_tab_2Fragment groupFragment;

    public static final int MESSAGE_FRAGMENT_TYPE = 1;
    public static final int CALL_FRAGMENT_TYPE = 2;
    public int currentFragmentType = -1;

    protected int getContentViewID() {
        return R.layout.fragment_friend;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set tag
        TAG_LOG = this.getClass().getSimpleName();

        mContext = getActivity();
        FragmentManager fragmentManager = getChildFragmentManager();
        if (savedInstanceState != null) {
            int type = savedInstanceState.getInt("currentFragmentType");
            messageFragment = (Friend_tab_1Fragment) fragmentManager.findFragmentByTag("message");
            groupFragment = (Friend_tab_2Fragment)fragmentManager.findFragmentByTag("group");
            if(type > 0)
                loadFragment(type);
        } else {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            Fragment mainFragment = fragmentManager.findFragmentByTag("message");
            if (mainFragment != null) {
                transaction.replace(R.id.friend_content, mainFragment);
                transaction.commit();
            } else {
                loadFragment(MESSAGE_FRAGMENT_TYPE);
            }
        }
    }


    @Override
    protected void initViews(View rootView) {


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastFragmentTag", currentFragmentType);
    }

    private void switchFragment(int type) {
        switch (type) {
            case MESSAGE_FRAGMENT_TYPE:
                loadFragment(MESSAGE_FRAGMENT_TYPE);
                break;
            case CALL_FRAGMENT_TYPE:
                loadFragment(CALL_FRAGMENT_TYPE);
                break;
        }

    }

    private void loadFragment(int type) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (type == CALL_FRAGMENT_TYPE) {
            if (groupFragment == null) {
                groupFragment = new Friend_tab_2Fragment();

                transaction.add(R.id.friend_content, groupFragment, "zhishi");
            } else {
                transaction.show(groupFragment);
            }
            if (messageFragment != null) {
                transaction.hide(messageFragment);
            }
            currentFragmentType = MESSAGE_FRAGMENT_TYPE;
        } else {
            if (messageFragment == null) {
                messageFragment = new Friend_tab_1Fragment();
                transaction.add(R.id.friend_content, messageFragment, "wenda");
            } else {
                transaction.show(messageFragment);
            }
            if (groupFragment != null) {
                transaction.hide(groupFragment);
            }
            currentFragmentType = CALL_FRAGMENT_TYPE;
        }
        transaction.commitAllowingStateLoss();
    }

    @OnClick({R.id.friend_message,R.id.friend_group})
    public void click(View v){
        switch (v.getId()){
            case R.id.friend_message:
                message.setTextColor(getResources().getColor(R.color.tab_after));
                group.setTextColor(getResources().getColor(R.color.title));
                message
                        .setBackgroundResource(R.drawable.frid_left_press);
                group
                        .setBackgroundResource(R.drawable.frid_right_unpress);
                switchFragment(MESSAGE_FRAGMENT_TYPE);
                break;
            case R.id.friend_group:
                message.setTextColor(getResources().getColor(R.color.title));
                group.setTextColor(getResources().getColor(R.color.tab_after));
                message
                        .setBackgroundResource(R.drawable.frid_left_unpress);
                group
                        .setBackgroundResource(R.drawable.frid_right_press);
                switchFragment(CALL_FRAGMENT_TYPE);
                break;
        }
    }



}
