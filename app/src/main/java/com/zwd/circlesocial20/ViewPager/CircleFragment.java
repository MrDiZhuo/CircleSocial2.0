package com.zwd.circlesocial20.ViewPager;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.zwd.circlesocial20.Base.BaseFragment;
import com.zwd.circlesocial20.Base.BasePopupWindow;
import com.zwd.circlesocial20.Circle.CircleMessage;
import com.zwd.circlesocial20.Circle.motions_publish;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.adapter.Circle_1Adapter;
import com.zwd.circlesocial20.widget.BackActionBar;

import java.util.ArrayList;

import butterknife.Bind;

import static com.zwd.circlesocial20.util.dip2pxUtils.dip2px;


public class CircleFragment extends BaseFragment {
    @Bind(R.id.circle_actionbar)
    BackActionBar actionbar;
    @Bind(R.id.circle_recycler)
    ListView tab_1;


    private ArrayList<String> mTitle;
    private BasePopupWindow mPopupWindow;
    View popupwindow;
    private Bundle bundle;
    private Circle_1Adapter mAdapter;




    protected int getContentViewID() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void initViews(View rootView) {
        bundle = new Bundle();
        bundle = getArguments();
        Context mContext;
        mContext =getContext();

        new MyTask().execute();

        popupwindow = getLayoutInflater(bundle).inflate(R.layout.item_circle_pop,null);
        RelativeLayout pop_text = (RelativeLayout) popupwindow.findViewById(R.id.circle_pop_text);
        RelativeLayout pop_view = (RelativeLayout) popupwindow.findViewById(R.id.circle_pop_view);
        RelativeLayout pop_picture = (RelativeLayout) popupwindow.findViewById(R.id.circle_pop_picture);
        RelativeLayout pop_title = (RelativeLayout) popupwindow.findViewById(R.id.circle_pop_title);
        /**
         * 每一个加监听
         */
        pop_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(motions_publish.class);
                mPopupWindow.dismiss();
            }
        });
        pop_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(motions_publish.class);
                mPopupWindow.dismiss();
            }
        });
        pop_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(motions_publish.class);
                mPopupWindow.dismiss();
            }
        });
        pop_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(motions_publish.class);
                mPopupWindow.dismiss();
            }
        });


        mPopupWindow = new BasePopupWindow(mContext);
        mPopupWindow.setAnimationStyle(R.style.circlepop_anim_style);
        mPopupWindow.setContentView(popupwindow);
        mPopupWindow.setWidth(dip2px(mContext,250));
        mPopupWindow.setHeight(dip2px(mContext,138));
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_pop));

        initActionBar(actionbar);

    }

    class MyTask extends AsyncTask<Void, Void, CircleMessage> {

        @Override
        protected CircleMessage doInBackground(Void... params) {
            String json = "{\"code\":200,\"msg\":\"ok\",list:["
                    + "{\"id\":110,\"head\":\"http://imgsrc.baidu.com/baike/pic/item/b219ebc4b74543a9e306551e1d178a82b80114c6.jpg\",\"user\":\"张三\",\"text\":\"大家好\",\"urls\":[]},"
                    + "{\"id\":111,\"head\":\"http://cdn.duitang.com/uploads/item/201609/25/20160925123723_2Vnji.jpeg\",\"user\":\"李四\",\"text\":\"大家好\",\"urls\":[\"http://img.5669.com/uploads/allimg/161221/31-1612211A349.jpg\"]},"
                    + "{\"id\":112,\"head\":\"http://www.ty163.cn/dou/uploads/allimg/20161219/234514_4518.jpg\",\"user\":\"王五\",\"text\":\"大家好\",\"urls\":[\"http://www.0168.cc/uploads/allimg/c161130/14P4B3K1P-44205.jpg\",\"http://img.mshishang.com/pics/2016/1223/20161223035157982.jpg\"]},"
                    + "{\"id\":113,\"head\":\"http://www.ty163.cn/dou/uploads/allimg/20161219/235223_5168.jpg\",\"user\":\"赵六\",\"text\":\"大家好\",\"urls\":[\"http://7xsbn8.com1.z0.glb.clouddn.com/14816176888.png\",\"http://7xsbn8.com1.z0.glb.clouddn.com/14816176888.png\",\"http://7xsbn8.com1.z0.glb.clouddn.com/14816176888.png\",\"http://i.shangc.net/2016/1223/20161223051809930.jpg\",\"http://www.akjunshi.com/upload/20160816/14713219976318.jpg\"]}]}";
            Gson gson = new Gson();
            CircleMessage msg = gson.fromJson(json, CircleMessage.class);
            return msg;
        }


        @Override
        protected void onPostExecute(CircleMessage result) {
            mAdapter = new Circle_1Adapter(mContext, result.list);
            tab_1.setAdapter(mAdapter);

        }



    }



    private void initActionBar(BackActionBar actionbar) {
        actionbar.hideBack();
        actionbar.hidesubTitle();
        actionbar.setTitle("圈子");
        actionbar.setCustomButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAtLocation(popupwindow,Gravity.NO_GRAVITY,dip2px(mContext,105),dip2px(mContext,55));

            }
        });
    }
}
