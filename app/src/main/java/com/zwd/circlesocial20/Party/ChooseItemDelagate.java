package com.zwd.circlesocial20.Party;

import com.zwd.circlesocial20.Base.ItemViewDelegate;
import com.zwd.circlesocial20.Base.ViewHolder;
import com.zwd.circlesocial20.Element.ChooseElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.R;

/**
 * Created by asus-pc on 2017/2/10.
 */

public class ChooseItemDelagate implements ItemViewDelegate<ChooseElement> {
    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.item_choose;
    }

    @Override
    public boolean isForViewType(ChooseElement item, int position)
    {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, ChooseElement choose, int position)
    {

        holder.setImageResource(R.id.choose_image,choose.getResourceId());
        holder.setText(R.id.choose_title,choose.getTitle());
        holder.setText(R.id.choose_text,choose.getText());
        holder.setText(R.id.choose_mark,String.valueOf(choose.getMark()));
    }

}
