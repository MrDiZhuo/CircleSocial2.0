package com.zwd.circlesocial20.Party;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.CommonAdapter;
import com.zwd.circlesocial20.adapter.PartyAdapter;
import com.zwd.circlesocial20.util.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class MyParty_1Fragment extends BaseFragment {
    @Bind(R.id.my_party_1_recyclerview)
    RecyclerView recycler;

    private List<PartyElement> partylist = new ArrayList<>();
    protected int getContentViewID() {
        return R.layout.fragment_my_party_1;
    }

    @Override
    protected void initViews(View rootView) {
        initlist();
        PartyAdapter partyadapter = new PartyAdapter(mContext,partylist);
        recycler.addItemDecoration(new RecyclerViewDivider(mContext, LinearLayoutManager.VERTICAL,R.drawable.party_hidder));
        recycler.setAdapter(partyadapter);
        partyadapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){
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
    }

}
