package com.zwd.circlesocial20.adapter;

import android.content.Context;

import com.amap.api.services.core.PoiItem;
import com.zwd.circlesocial20.R;

import java.util.List;

public class AddressAdapter extends CommonAddressAdapter<PoiItem>{

	public AddressAdapter(Context context, List<PoiItem> mDatas,
						  int itemLayoutId) {
		super(context, mDatas, itemLayoutId);
	}

	@Override
	public void convert(ViewHolder_2 helper, PoiItem item) {
		helper.setText(R.id.tvMLIPoiName, item.getTitle());
		helper.setText(R.id.tvMLIPoiAddress, item.getProvinceName()+item.getCityName()+item.getAdName());
	}

}
