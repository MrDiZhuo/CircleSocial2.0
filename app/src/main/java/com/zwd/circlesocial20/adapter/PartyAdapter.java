package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwd.circlesocial20.Party.PartyItemDelagate;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.Element.PartyElement;

import java.util.List;

/**
 * Created by asus-pc on 2016/12/11.
 */

public class PartyAdapter extends MultiItemTypeAdapter<PartyElement>{
    public PartyAdapter(Context context, List<PartyElement> datas) {
        super(context, datas);
        addItemViewDelegate(new PartyItemDelagate());
    }
}
