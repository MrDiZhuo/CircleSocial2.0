package com.zwd.circlesocial20.Party;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.loveplusplus.demo.image.ImagePagerActivity;
import com.loveplusplus.demo.image.MyGridAdapter;
import com.loveplusplus.demo.image.NoScrollGridView;
import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;

import butterknife.Bind;

public class Choose_Introduce extends BaseActivity {
    @Bind(R.id.choose_introduce_actionbar)
    BackActionBar actionBar;
    @Bind(R.id.choose_introduce_scrollview)
    ScrollView scrollView;
    @Bind(R.id.choose_introduce_image)
    ImageView image;
    @Bind(R.id.choose_introduce_title)
    TextView title;
    @Bind(R.id.choose_introduce_text)
    TextView text;
    @Bind(R.id.choose_introduce_grid)
    NoScrollGridView grid;
    @Bind(R.id.choose_introduce_location)
    RelativeLayout location;
    @Bind(R.id.choose_introduce_phone)
    RelativeLayout phone;
    @Bind(R.id.choose_introduce_btn)
    Button btn;

    private String[] urls={"http://www.ty163.cn/dou/uploads/allimg/20161219/235223_5168.jpg"
            ,"http://www.ty163.cn/dou/uploads/allimg/20161219/235223_5168.jpg"
            ,"http://www.ty163.cn/dou/uploads/allimg/20161219/235223_5168.jpg"};
    private Context context = this;
    // 记录首次按下位置
    private float mFirstPosition = 0;
    // 是否正在放大
    private Boolean mScaling = false;

    private DisplayMetrics metric;

    protected int getContentView(){
        return R.layout.activity_choose__introduce;
    }

    protected void initViews() {
        initActionBar(actionBar);
        if(urls!=null&&urls.length>0){
            grid.setVisibility(View.VISIBLE);
            grid.setAdapter(new MyGridAdapter(urls, mContext));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    imageBrower(position,urls);
                }
            });
        }else{
            grid.setVisibility(View.GONE);
        }

        // 获取屏幕宽高
        metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        // 设置图片初始大小 这里我设为满屏的16:9
        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) image.getLayoutParams();
        lp.width = metric.widthPixels;
        lp.height = metric.widthPixels * 9 / 16;
        image.setLayoutParams(lp);
        // 监听滚动事件
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) image
                        .getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        // 手指离开后恢复图片
                        mScaling = false;
                        replyImage();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!mScaling) {
                            if (scrollView.getScrollY() == 0) {
                                mFirstPosition = event.getY();// 滚动到顶部时记录位置，否则正常返回
                            } else {
                                break;
                            }
                        }
                        int distance = (int) ((event.getY() - mFirstPosition) * 0.6); // 滚动距离乘以一个系数
                        if (distance < 0) { // 当前位置比记录位置要小，正常返回
                            break;
                        }

                        // 处理放大
                        mScaling = true;
                        lp.width = metric.widthPixels + distance;
                        lp.height = (metric.widthPixels + distance) * 9 / 16;
                        image.setLayoutParams(lp);
                        return true; // 返回true表示已经完成触摸事件，不再处理
                }
                return false;
            }
        });

    }
    private void imageBrower(int position, String[] urls) {
        Intent intent = new Intent(mContext, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        mContext.startActivity(intent);
    }

    private void initActionBar(BackActionBar actionBar) {
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        actionBar.setTitle("胖哥俩肉蟹煲");
        actionBar.hidesubTitle();
        actionBar.hideCustomButton();
    }

    // 回弹动画 (使用了属性动画)
    public void replyImage() {
        final ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) image
                .getLayoutParams();
        final float w = image.getLayoutParams().width;// 图片当前宽度
        final float h = image.getLayoutParams().height;// 图片当前高度
        final float newW = metric.widthPixels;// 图片原宽度
        final float newH = metric.widthPixels * 9 / 16;// 图片原高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F)
                .setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.width = (int) (w - (w - newW) * cVal);
                lp.height = (int) (h - (h - newH) * cVal);
                image.setLayoutParams(lp);
            }
        });
        anim.start();

    }

}
