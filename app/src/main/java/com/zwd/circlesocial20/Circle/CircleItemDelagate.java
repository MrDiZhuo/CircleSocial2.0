package com.zwd.circlesocial20.Circle;

import com.zwd.circlesocial20.Base.ItemViewDelegate;
import com.zwd.circlesocial20.Base.ViewHolder;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;

/**
 * Created by asus-pc on 2017/1/19.
 */

public class CircleItemDelagate implements ItemViewDelegate<CircleItemDelagate> {

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.item_circle_tab_1;
    }

    @Override
    public boolean isForViewType(CircleItemDelagate item, int position)
    {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, CircleItemDelagate party, int position)
    {
       /* holder.setImageResource()

        holder.setImageResource(R.id.item_party_image,party.getResourceId());
        holder.setText(R.id.item_party_title,party.getTitle());
        holder.setText(R.id.item_party_text,party.getText());
        holder.setText(R.id.item_party_money,String.valueOf(party.getMoney()));
        holder.setText(R.id.item_party_num,party.getAvery());*/
    }
}
