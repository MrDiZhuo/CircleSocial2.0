package com.zwd.circlesocial20.Party;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Element.ChooseElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.ChooseAdapter;
import com.zwd.circlesocial20.adapter.CommonAdapter;
import com.zwd.circlesocial20.adapter.PartyAdapter;
import com.zwd.circlesocial20.util.RecyclerViewDivider;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class Choose extends BaseActivity {
    @Bind(R.id.choose_action_bar)
    BackActionBar actionBar;
    @Bind(R.id.choose_list)
    RecyclerView list;

    private List<ChooseElement> chooselist = new ArrayList<>();
    protected int getContentView(){
        return R.layout.activity_choose;
    }

    protected void initViews() {
        initActionBar(actionBar);
        initlist();

        ChooseAdapter chooseadapter= new ChooseAdapter(this,chooselist);
        list.addItemDecoration(new RecyclerViewDivider(mContext, LinearLayoutManager.VERTICAL,R.drawable.party_hidder));
        list.setAdapter(chooseadapter);
        chooseadapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                goActivity(Choose_Introduce.class);
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
            ChooseElement choose1 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose1);
            ChooseElement choose2 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose2);
            ChooseElement choose3 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose3);
            ChooseElement choose4 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose4);
            ChooseElement choose5 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose5);
            ChooseElement choose6 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose6);
            ChooseElement choose7 = new ChooseElement(R.mipmap.party_test,"胖哥俩肉蟹煲","我们的肉蟹煲很好吃",5);
            chooselist.add(choose7);
        }
    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        actionBar.setTitle("推荐商家");
        actionBar.hideCustomButton();
        actionBar.hidesubTitle();
    }

}
