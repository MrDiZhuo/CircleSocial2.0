package com.zwd.circlesocial20.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Party.MyParty;
import com.zwd.circlesocial20.Party.Party_list;
import com.zwd.circlesocial20.Party.SortHolder;
import com.zwd.circlesocial20.Party.SortHolder_2;
import com.zwd.circlesocial20.Party.SortHolder_3;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.CommonAdapter;
import com.zwd.circlesocial20.adapter.PartyAdapter;
import com.zwd.circlesocial20.adapter.ViewPagerAdapter;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.util.BannerViewPager;
import com.zwd.circlesocial20.util.OnPageClickListener;
import com.zwd.circlesocial20.util.RecyclerViewDivider;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class PartyFragment extends BaseFragment{
    @Bind(R.id.party_actionbar)
    BackActionBar actionBar;
    @Bind(R.id.banner)
    BannerViewPager bannerViewPager;
    @Bind(R.id.party_parent)
    LinearLayout parent;
    @Bind(R.id.party_list)
    RecyclerView party_list;
    @Bind(R.id.scrollView)
    AppBarLayout scrollview;
    @Bind(R.id.party_buy)
    View party_buy;
    @Bind(R.id.ll_top)
    LinearLayout top;


    @Bind(R.id.ll_quyu)
    LinearLayout quyu;
    @Bind(R.id.quyu)
    TextView text_quyu;
    @Bind(R.id.icon1)
    ImageView quyu_icon;

    @Bind(R.id.ll_jiage)
    LinearLayout jiage;
    @Bind(R.id.jiage)
    TextView text_jiage;
    @Bind(R.id.icon2)
    ImageView jiage_icon;

    @Bind(R.id.ll_huxing)
    LinearLayout huxing;
    @Bind(R.id.huxing)
    TextView text_huxing;
    @Bind(R.id.icon3)
    ImageView huxing_icon;


    private ViewPagerAdapter mAdapter;

    private Bundle bundle;
    private List<PartyElement> partylist = new ArrayList<>();

    /** type2 */
    SortHolder mSortHolder_quyu;
    PopupWindow pop_quyu;

    SortHolder_2 mSortHolder_jiage;
    PopupWindow pop_jiage;

    SortHolder_3 mSortHolder_huxing;
    PopupWindow pop_huxing;


    protected int getContentViewID() {
        return R.layout.fragment_party;
    }

    @Override
    protected void initViews(View rootView) {

        bundle = new Bundle();
        bundle = getArguments();
        final Context mContext;
        mContext = getContext();
        initActionBar(actionBar);



        /**
         * 下拉筛选框
         */
        mSortHolder_quyu = new SortHolder(mContext);
        pop_quyu = new PopupWindow(mSortHolder_quyu.getRootView(), WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,true);
        pop_quyu.setFocusable(true);
        pop_quyu.setOutsideTouchable(true);
        mSortHolder_quyu.setOnSortInfoSelectedListener(new SortHolder.OnSortInfoSelectedListener() {
            @Override
            public void onSortInfoSelected(String info) {
                text_quyu.setText(getQuyuString(info));
                pop_quyu.dismiss();
                text_quyu.setTextColor(getResources().getColor(R.color.nomaltext));
                quyu_icon.setImageResource(R.mipmap.ic_down);
            }
        });
        mSortHolder_quyu.pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_quyu.dismiss();
                text_quyu.setTextColor(getResources().getColor(R.color.nomaltext));
                quyu_icon.setImageResource(R.mipmap.ic_down);
            }
        });

        mSortHolder_jiage = new SortHolder_2(mContext);
        pop_jiage = new PopupWindow(mSortHolder_jiage.getRootView(),WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,true);
        pop_jiage.setFocusable(true);
        pop_jiage.setOutsideTouchable(true);
        mSortHolder_jiage.setOnSortInfoSelectedListener(new SortHolder.OnSortInfoSelectedListener() {
            @Override
            public void onSortInfoSelected(String info) {
                text_jiage.setText(getJiageString(info));
                pop_jiage.dismiss();
                text_jiage.setTextColor(getResources().getColor(R.color.nomaltext));
                jiage_icon.setImageResource(R.mipmap.ic_down);
            }
        });
        mSortHolder_jiage.pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_jiage.dismiss();
                text_jiage.setTextColor(getResources().getColor(R.color.nomaltext));
                jiage_icon.setImageResource(R.mipmap.ic_down);
            }
        });

        mSortHolder_huxing = new SortHolder_3(mContext);
        pop_huxing = new PopupWindow(mSortHolder_huxing.getRootView(),WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,true);
        pop_huxing.setFocusable(true);
        pop_huxing.setOutsideTouchable(true);
        mSortHolder_huxing.setOnSortInfoSelectedListener(new SortHolder.OnSortInfoSelectedListener() {
            @Override
            public void onSortInfoSelected(String info) {
                text_huxing.setText(getHuxingString(info));
                pop_huxing.dismiss();
                text_huxing.setTextColor(getResources().getColor(R.color.nomaltext));
                huxing_icon.setImageResource(R.mipmap.ic_down);
            }
        });
        mSortHolder_huxing.pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_huxing.dismiss();
                text_huxing.setTextColor(getResources().getColor(R.color.nomaltext));
                huxing_icon.setImageResource(R.mipmap.ic_down);
            }
        });


 
        /**
         ** 广告滑动
         */
        ImageView iv1 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv2 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv3 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv4 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv5 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv6 = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.banner_item,bannerViewPager,false);

        iv1.setImageResource(R.mipmap.ic_img01);
        iv2.setImageResource(R.mipmap.ic_img02);
        iv3.setImageResource(R.mipmap.ic_img03);
        iv4.setImageResource(R.mipmap.ic_img04);
        iv5.setImageResource(R.mipmap.ic_img05);
        iv6.setImageResource(R.mipmap.ic_img06);
        //一开始只添加5个Item
        final List<ImageView> mViews = new ArrayList<>();
        mViews.add(iv1);
        mViews.add(iv2);
        mViews.add(iv3);
        mViews.add(iv4);
        mViews.add(iv5);

        mAdapter = new ViewPagerAdapter(mViews, new OnPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Log.d("cylog","position:"+position);
            }
        });
        bannerViewPager.setAdapter(mAdapter);

        /**
         * recyclerview
         */
        initlist();
        PartyAdapter partyadapter = new PartyAdapter(mContext,partylist);
        party_list.addItemDecoration(new RecyclerViewDivider(mContext, LinearLayoutManager.VERTICAL,R.drawable.party_hidder));
        party_list.setAdapter(partyadapter);
        partyadapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position)
            {
                goActivity(Party_list.class);
                Toast.makeText(mContext, "Click:" +partylist.get(position).getText().toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                Toast.makeText(mContext, "LongClick:" + position , Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }



    @OnClick({R.id.ll_quyu,R.id.ll_jiage,R.id.ll_huxing})
    public void click(View v){
        switch (v.getId()){
            case R.id.ll_quyu:
                text_quyu.setTextColor(getResources().getColor(R.color.tab_after));
                quyu_icon.setImageResource(R.mipmap.ic_up_blue);
                pop_quyu.showAsDropDown(quyu, Gravity.BOTTOM,0,0);
                break;
            case R.id.ll_jiage:
                text_jiage.setTextColor(getResources().getColor(R.color.tab_after));
                jiage_icon.setImageResource(R.mipmap.ic_up_blue);
                pop_jiage.showAsDropDown(jiage, Gravity.BOTTOM,0,0);
                break;
            case R.id.ll_huxing:
                text_huxing.setTextColor(getResources().getColor(R.color.tab_after));
                huxing_icon.setImageResource(R.mipmap.ic_up_blue);
                pop_huxing.showAsDropDown(huxing, Gravity.BOTTOM,0,0);
                break;

        }
    }

    private String getHuxingString(String info) {
        if(SortHolder.SORT_BY_NORULE.equals(info)){
            return "排列地点";
        }else if(SortHolder.SORT_BY_EVALUATION.equals(info)){
            return "江干";
        }else if(SortHolder.SORT_BY_PRICELOW.equals(info)){
            return "西湖";
        }else if(SortHolder.SORT_BY_PRICEHIGH.equals(info)){
            return "滨江";
        }else if(SortHolder.SORT_BY_DISTANCE.equals(info)){
            return "萧山";
        }else if(SortHolder.SORT_BY_TIME.equals(info)){
            return("临安");
        }
        return "排列地点";
    }

    private String getJiageString(String info) {
        if(SortHolder.SORT_BY_NORULE.equals(info)){
            return "聚会类型";
        }else if(SortHolder.SORT_BY_EVALUATION.equals(info)){
            return "聚会";
        }else if(SortHolder.SORT_BY_PRICELOW.equals(info)){
            return "骑行";
        }else if(SortHolder.SORT_BY_PRICEHIGH.equals(info)){
            return "登山";
        }else if(SortHolder.SORT_BY_DISTANCE.equals(info)){
            return "聚餐";
        }else if(SortHolder.SORT_BY_TIME.equals(info)){
            return("游戏");
        }
        return "聚会类型";
    }

    private String getQuyuString(String info){
        if(SortHolder.SORT_BY_NORULE.equals(info)){
            return "排列顺序";
        }else if(SortHolder.SORT_BY_EVALUATION.equals(info)){
            return "离我最近";
        }else if(SortHolder.SORT_BY_PRICELOW.equals(info)){
            return "参与人数最多";
        }else if(SortHolder.SORT_BY_PRICEHIGH.equals(info)){
            return "人均费用最少";
        }else if(SortHolder.SORT_BY_DISTANCE.equals(info)){
            return "聚会时间最短";
        }else if(SortHolder.SORT_BY_TIME.equals(info)){
            return("开始时间最近");
        }
        return "排列顺序";
    }




    private void initlist() {
            PartyElement party1 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party1);
            PartyElement party2 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party2);
            PartyElement party3 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party3);
            PartyElement party4 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party4);
            PartyElement party5 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party5);
            PartyElement party6 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party6);
            PartyElement party7 = new PartyElement(R.mipmap.party_test,"奥凯","好久没唱歌了，有没有一起的",20,"1/10");
            partylist.add(party7);

    }



///

    private void initActionBar(BackActionBar actionbar) {
        actionbar.hideCustomButton();
        actionbar.hideBack();
        actionbar.setTitle("聚会");
        actionbar.setsbTitle("我的活动");
        actionbar.setSubtitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(MyParty.class);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }











}