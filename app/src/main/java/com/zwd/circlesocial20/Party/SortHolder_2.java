package com.zwd.circlesocial20.Party;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwd.circlesocial20.R;

import java.util.List;

/**
 * Created by asus-pc on 2017/2/26.
 */

public class SortHolder_2  extends BaseWidgetHolder<List<String>> {

    /** 综合排序 */
    public static final String SORT_BY_NORULE = "";
    /** 评价最高 */
    public static final String SORT_BY_EVALUATION = "2";
    /** 价格最低 */
    public static final String SORT_BY_PRICELOW = "3";
    /** 价格最高 */
    public static final String SORT_BY_PRICEHIGH = "4";
    /** 离我最近 */
    public static final String SORT_BY_DISTANCE = "5";

    public static final String SORT_BY_TIME = "6";

    /** 综合排序 */
    private View mComprehensiveView;
    /** 评价最高 */
    private View mHighEvaluateView;
    /** 价格最低 */
    private View mLowPriceView;
    /** 价格最高 */
    private View mHighPriceView;
    /** 离我最近 */
    private View mDistanceView;

    private View mTimeView;

    private ImageView mRecordImageView;
    private ImageView mComprehensiveImage;
    private ImageView mHighEvaluateImage;
    private ImageView mLowPriceImage;
    private ImageView mHighPriceImage;
    private ImageView mDistanceImage;
    private ImageView mTimeImage;

    private TextView mRecordTextView;
    private TextView mComprehensiveText;
    private TextView mHighEvaluateText;
    private TextView mLowPriceText;
    private TextView mHighPriceText;
    private TextView mDistanceText;
    private TextView mTimeText;

    private View view;

    public View pop;

    private SortHolder.OnSortInfoSelectedListener mOnSortInfoSelectedListener;

    public SortHolder_2(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.layout_holder_sort_2, null);

        pop = (View)view.findViewById(R.id.view_2);
        mComprehensiveView = view.findViewById(R.id.re_sort1_2);
        mHighEvaluateView = view.findViewById(R.id.re_sort2_2);
        mLowPriceView = view.findViewById(R.id.re_sort4_2);
        mHighPriceView = view.findViewById(R.id.re_sort5_2);
        mDistanceView = view.findViewById(R.id.re_sort6_2);
        mTimeView = view.findViewById(R.id.re_sort7_2);

        mComprehensiveImage = (ImageView) view.findViewById(R.id.img_sort1_2);
        mHighEvaluateImage = (ImageView) view.findViewById(R.id.img_sort2_2);
        mLowPriceImage = (ImageView) view.findViewById(R.id.img_sort4_2);
        mHighPriceImage = (ImageView) view.findViewById(R.id.img_sort5_2);
        mDistanceImage = (ImageView) view.findViewById(R.id.img_sort6_2);
        mTimeImage = (ImageView)view.findViewById(R.id.img_sort7_2);

        mComprehensiveText = (TextView) view.findViewById(R.id.sort1_2);
        mHighEvaluateText = (TextView) view.findViewById(R.id.sort2_2);
        mLowPriceText = (TextView) view.findViewById(R.id.sort4_2);
        mHighPriceText = (TextView) view.findViewById(R.id.sort5_2);
        mDistanceText = (TextView) view.findViewById(R.id.sort6_2);
        mTimeText = (TextView)view.findViewById(R.id.sort7_2);



        //综合排序
        mComprehensiveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_NORULE, mComprehensiveImage,mComprehensiveText);
            }
        });

        //评价最高
        mHighEvaluateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_EVALUATION, mHighEvaluateImage,mHighEvaluateText);
            }
        });

        //价格最低
        mLowPriceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_PRICELOW, mLowPriceImage,mLowPriceText);
            }
        });

        //价格最高
        mHighPriceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_PRICEHIGH, mHighPriceImage,mHighPriceText);
            }
        });
        //离我最近
        mDistanceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_DISTANCE, mDistanceImage,mDistanceText);
            }
        });
        mTimeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_TIME,mTimeImage,mTimeText);
            }
        });

        return view;
    }

    @Override
    public void refreshView(List<String> data) {
        mComprehensiveImage.setVisibility(View.INVISIBLE);
        mHighEvaluateImage.setVisibility(View.INVISIBLE);
        mLowPriceImage.setVisibility(View.INVISIBLE);
        mHighPriceImage.setVisibility(View.INVISIBLE);
        mDistanceImage.setVisibility(View.INVISIBLE);
        mTimeImage.setVisibility(View.INVISIBLE);
    }

    private void retSortInfo(String info, ImageView imageView,TextView textView){

        if(mRecordImageView != null){
            mRecordImageView.setVisibility(View.INVISIBLE);
            mRecordTextView.setTextColor(view.getResources().getColor(R.color.nomaltext));
        }
        mRecordImageView = imageView;
        mRecordTextView = textView;

        imageView.setVisibility(View.VISIBLE);
        textView.setTextColor(view.getResources().getColor(R.color.tab_after));


        if(mOnSortInfoSelectedListener != null){
            mOnSortInfoSelectedListener.onSortInfoSelected(info);
        }
    }

    public void setOnSortInfoSelectedListener(SortHolder.OnSortInfoSelectedListener onSortInfoSelectedListener){
        this.mOnSortInfoSelectedListener = onSortInfoSelectedListener;
    }

    public interface OnSortInfoSelectedListener{
        void onSortInfoSelected(String info);
    }
}
