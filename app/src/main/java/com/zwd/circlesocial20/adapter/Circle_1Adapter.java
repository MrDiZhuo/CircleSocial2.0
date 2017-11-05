package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loveplusplus.demo.image.ImagePagerActivity;
import com.loveplusplus.demo.image.MyBean;
import com.loveplusplus.demo.image.MyGridAdapter;
import com.loveplusplus.demo.image.MyListAdapter;
import com.loveplusplus.demo.image.NoScrollGridView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zwd.circlesocial20.Element.Circle_1Element;
import com.zwd.circlesocial20.R;

import java.util.ArrayList;

/**
 * Created by asus-pc on 2017/1/21.
 */

public class Circle_1Adapter extends BaseAdapter {

    private ArrayList<Circle_1Element> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public Circle_1Adapter(Context context,ArrayList<Circle_1Element> list) {
        mInflater = LayoutInflater.from(context);
        mContext=context;
        this.mList=list;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Circle_1Element getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_circle_tab_1, null);
            holder.head=(ImageView)convertView.findViewById(R.id.item_circle_tab_1_head) ;
            holder.user = (TextView)convertView.findViewById(R.id.item_circle_tab_1_user);
            holder.text=(TextView)convertView.findViewById(R.id.item_circle_tab_1_text);
            holder.picture=(NoScrollGridView)convertView.findViewById(R.id.item_circle_tab_1_picture);
            holder.remark = (ListView)convertView.findViewById(R.id.item_circle_tab_1_remark);
            holder.time = (TextView)convertView.findViewById(R.id.item_circle_tab_1_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Circle_1Element bean = getItem(position);

        ImageLoader.getInstance().displayImage(bean.head, holder.head);
        holder.user.setText(bean.user);
        holder.text.setText(bean.text);
        if(bean.urls!=null&&bean.urls.length>0){
            holder.picture.setVisibility(View.VISIBLE);
            holder.picture.setAdapter(new MyGridAdapter(bean.urls, mContext));
            holder.picture.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    imageBrower(position,bean.urls);
                }
            });
        }else{
            holder.picture.setVisibility(View.GONE);
        }
        return convertView;
    }

    private void imageBrower(int position, String[] urls) {
        Intent intent = new Intent(mContext, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        mContext.startActivity(intent);
    }
    private static class ViewHolder {

        ImageView head;
        TextView user;
        TextView text;
        NoScrollGridView picture;
        ListView remark;
        TextView time;
    }
}
