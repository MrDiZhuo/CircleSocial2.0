package com.zwd.circlesocial20.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Element.DiscountElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.Party.Party_list;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.CommonAdapter;
import com.zwd.circlesocial20.adapter.DiscountAdapter;
import com.zwd.circlesocial20.adapter.PartyAdapter;
import com.zwd.circlesocial20.util.RecyclerViewDivider;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class Me_Discount extends BaseActivity {
    @Bind(R.id.Me_Discount_action)
    BackActionBar actionBar;
    @Bind(R.id.Me_Discount_list)
    RecyclerView list;

    private List<DiscountElement> discountlist = new ArrayList<>();


    @Override
    protected int getContentView() {
        return R.layout.activity_me__discount;
    }
    @Override
    protected void initViews(){
        initActionBar(actionBar);

        initlist();
        DiscountAdapter discountadapter = new DiscountAdapter(mContext,discountlist);
        list.addItemDecoration(new RecyclerViewDivider(mContext, LinearLayoutManager.VERTICAL,R.drawable.party_hidder));
        list.setAdapter(discountadapter);
        discountadapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position)
            {
                Toast.makeText(mContext, "Click:" + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                Toast.makeText(mContext, "LongClick:" + position , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void initlist() {
        for(int i=0;i<2;i++){
            DiscountElement discount1 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount1);
            DiscountElement discount2 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount2);
            DiscountElement discount3 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount3);
            DiscountElement discount4 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount4);
            DiscountElement discount5 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount5);
            DiscountElement discount6 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount6);
            DiscountElement discount7 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount7);
            DiscountElement discount8 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount8);
            DiscountElement discount9 = new DiscountElement(10,"2016/8/20","23.59");
            discountlist.add(discount9);
        }

    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.hidesubTitle();
        actionBar.hideCustomButton();
        actionBar.setTitle("优惠券");
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
