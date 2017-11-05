package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zwd.circlesocial20.R;

import java.util.ArrayList;

/**
 * Created by asus-pc on 2016/12/9.
 */

public class MeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> list;
    public MeAdapter(Context context, ArrayList<String> list){
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

        if(convertView==null){
            convertView=inflater.inflate(R.layout.activity_me_item,parent,false);

            convertView.setTag(new MeAdapter.ViewHolder(convertView));
        }
        MeAdapter.ViewHolder holder=(MeAdapter.ViewHolder)convertView.getTag();
        holder.textView.setText(list.get(position));
        return convertView;
    }

    private class ViewHolder {
        public TextView textView;
        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.me_item_text);
        }
    }
}



