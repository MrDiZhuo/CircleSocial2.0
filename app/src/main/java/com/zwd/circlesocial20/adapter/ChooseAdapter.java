package com.zwd.circlesocial20.adapter;

import android.content.Context;

import com.zwd.circlesocial20.Element.ChooseElement;
import com.zwd.circlesocial20.Element.PartyElement;
import com.zwd.circlesocial20.Party.ChooseItemDelagate;
import com.zwd.circlesocial20.Party.PartyItemDelagate;

import java.util.List;

/**
 * Created by asus-pc on 2017/2/10.
 */

public class ChooseAdapter extends MultiItemTypeAdapter<ChooseElement> {
    public ChooseAdapter(Context context, List<ChooseElement> datas) {
        super(context, datas);
        addItemViewDelegate(new ChooseItemDelagate());
    }
}
