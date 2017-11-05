package com.zwd.circlesocial20.Me;

import com.zwd.circlesocial20.Base.ItemViewDelegate;
import com.zwd.circlesocial20.Base.ViewHolder;
import com.zwd.circlesocial20.Element.DiscountElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;

/**
 * Created by asus-pc on 2016/12/17.
 */

public class MeItemDelagate implements ItemViewDelegate<DiscountElement> {

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.item_discount;
    }

    @Override
    public boolean isForViewType(DiscountElement item, int position)
    {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, DiscountElement discount, int position)
    {
        holder.setText(R.id.Me_Discount_money,String.valueOf(discount.getMoney()));
        holder.setText(R.id.Me_Discount_date,discount.getDate());
        holder.setText(R.id.Me_Discount_time,discount.getTime());
    }
}
