package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zwd.circlesocial20.R;

import java.util.ArrayList;

/**
 * Created by asus-pc on 2016/10/29.
 */

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> list;
    public ListViewAdapter(Context context, ArrayList<String> list){
        super();
        this.inflater=LayoutInflater.from(context);
        this.list=list;
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if(convertView==null){
            convertView=inflater.inflate(R.layout.lv_items,parent,false);
            viewHolder =new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder=(ViewHolder)convertView.getTag();
        holder.textView.setText(list.get(position));
        return convertView;
    }

    private class ViewHolder {
        public TextView textView;

    }

}
