package com.zwd.circlesocial20.Party;

import com.zwd.circlesocial20.Base.ItemViewDelegate;
import com.zwd.circlesocial20.Base.ViewHolder;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;

/**
 * Created by asus-pc on 2016/12/11.
 */

public class PartyItemDelagate implements ItemViewDelegate<PartyElement>{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.item_party;
    }

    @Override
    public boolean isForViewType(PartyElement item, int position)
    {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, PartyElement party, int position)
    {
        holder.setImageResource(R.id.item_party_image,party.getResourceId());
        holder.setText(R.id.item_party_title,party.getTitle());
        holder.setText(R.id.item_party_text,party.getText());
        holder.setText(R.id.item_party_money,String.valueOf(party.getMoney()));
        holder.setText(R.id.item_party_num,party.getAvery());
    }
}
