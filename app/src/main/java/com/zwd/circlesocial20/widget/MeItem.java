package com.zwd.circlesocial20.widget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zwd.circlesocial20.R;

public class MeItem extends LinearLayout {
    View contentView;
    RelativeLayout item;
    TextView text;

    public MeItem(Context context){
        super(context);
        initViews(context);
    }

    public MeItem(Context context, AttributeSet attrs){
        super(context,attrs);
        initViews(context);
    }

    public MeItem(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        initViews(context);
    }
    public void initViews(Context context){
        contentView = LayoutInflater.from(context).inflate(R.layout.activity_me_item,this)
                .findViewById(R.id.activity_me_item);
        item = (RelativeLayout) contentView.findViewById(R.id.me_item);
        text = (TextView) contentView.findViewById(R.id.me_item_text);
    }

    public void setTitle(String stitle){
        text.setText(stitle);
    }

    public String getTitle(){
        return text.getText().toString();
    }
    public void setItemonClickListener(OnClickListener listener){
        item.setOnClickListener(listener);
    }

}
