package com.zwd.circlesocial20.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class ViewHolder_2 {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	private com.nostra13.universalimageloader.core.ImageLoader loader = ImageLoader.getInstance();
	private ViewHolder_2(Context context, ViewGroup parent, int layoutId,
						 int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		mConvertView.setTag(this);
		loader.init(ImageLoaderConfiguration.createDefault(context));
	}

	/**
	 * 拿到一个ViewHolder对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static ViewHolder_2 get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder_2(context, parent, layoutId, position);
		}
		return (ViewHolder_2) convertView.getTag();
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder_2 setText(int viewId, String text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}
	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param
	 * @return
	 */
	public ViewHolder_2 setText(int viewId, android.text.SpannableString  styledText) {
		TextView view = getView(viewId);
		view.setText(styledText,TextView.BufferType.SPANNABLE);
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder_2 setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);

		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param
	 * @return
	 */
	public ViewHolder_2 setImageBitmap(int viewId, Bitmap bm) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param
	 * @return
	 */
	public ViewHolder_2 setImageByUrl(int viewId, String url) {
		loader.displayImage(url, (ImageView)mConvertView.findViewById(viewId), CommonTools.getDefaultImgOption());
		return this;
	}

	public int getPosition() {
		return mPosition;
	}

}
