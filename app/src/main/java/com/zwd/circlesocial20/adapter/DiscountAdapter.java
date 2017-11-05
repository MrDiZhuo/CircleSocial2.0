package com.zwd.circlesocial20.adapter;

import android.content.Context;

import com.zwd.circlesocial20.Element.DiscountElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.Me.MeItemDelagate;
import com.zwd.circlesocial20.Party.PartyItemDelagate;

import java.util.List;

/**
 * Created by asus-pc on 2016/12/17.
 */

public class DiscountAdapter extends MultiItemTypeAdapter<DiscountElement> {
    public DiscountAdapter(Context context, List<DiscountElement> datas) {
        super(context, datas);
        addItemViewDelegate(new MeItemDelagate());
    }
}
