package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.util.CircleImageView;

/**
 * Created by asus-pc on 2017/2/11.
 */

public class SampleAdapter_1 extends BaseExpandableListAdapter {
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    private final int[] mGroupsonline = {
            4,
            4,
            4,
            4,
            4
    };
    private final int[] mGroupsall = {
            4,
            4,
            4,
            4,
            4
    };
    private final String[] mGroups = {
            "浙江传媒学院",
            "杭州电子科技大学",
            "中国计量大学",
            "浙江理工大学",
            "杭州职业技术学院"
    };

    private final int[][] mChildsDrawables = {
            {R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head},
            {R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head},
            {R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head},
            {R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head},
            {R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head,R.mipmap.me_head}
    };

    private final String[][] mChildsTitle = {
            {"他是徐小平","他是徐小平","他是徐小平","他是徐小平"},
            {"他是徐小平","他是徐小平","他是徐小平","他是徐小平"},
            {"他是徐小平","他是徐小平","他是徐小平","他是徐小平"},
            {"他是徐小平","他是徐小平","他是徐小平","他是徐小平"},
            {"他是徐小平","他是徐小平","他是徐小平","他是徐小平"}
    };
    private final String[][] mChildsText=

            {
                    {
                            "我不高兴！", "我不高兴！", "我不高兴！", "我不高兴！"
                    },
                    {
                            "我不高兴！", "我不高兴！", "我不高兴！", "我不高兴！"
                    },
                    {
                            "我不高兴！", "我不高兴！", "我不高兴！", "我不高兴！"
                    },
                    {
                            "我不高兴！", "我不高兴！", "我不高兴！", "我不高兴！"
                    },
                    {
                            "我不高兴！", "我不高兴！", "我不高兴！", "我不高兴！"
                    }
            };


    public SampleAdapter_1(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.friend_parent_item, parent, false);
        }

        final TextView text_title= (TextView) convertView.findViewById(R.id.friend_parent_title);
        text_title.setText(mGroups[groupPosition]);

        final TextView text_online= (TextView) convertView.findViewById(R.id.friend_parent_online);
        text_online.setText(String.valueOf(mGroupsonline[groupPosition]));

        final TextView text_all= (TextView) convertView.findViewById(R.id.friend_parent_all);
        text_all.setText(String.valueOf(mGroupsall[groupPosition]));


        final ImageView expandedImage = (ImageView) convertView.findViewById(R.id.friend_parent_img);
        final int resId = isExpanded ? R.drawable.ic_down : R.drawable.friend_close;
        expandedImage.setImageResource(resId);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildsTitle[groupPosition].length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildsTitle[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.friend_child_item, parent, false);
        }
        final CircleImageView image = (CircleImageView) convertView.findViewById(R.id.friend_child_head);
        image.setImageResource(mChildsDrawables[groupPosition][childPosition]);

        final TextView child_title = (TextView) convertView.findViewById(R.id.friend_child_title);
        child_title.setText(mChildsTitle[groupPosition][childPosition]);

        final TextView child_text = (TextView) convertView.findViewById(R.id.friend_child_mood);
        child_text.setText(mChildsText[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        Toast.makeText(mContext, "这是第"+groupPosition+"组，第"+childPosition+"个", Toast.LENGTH_SHORT).show();

        return true;
    }
}
