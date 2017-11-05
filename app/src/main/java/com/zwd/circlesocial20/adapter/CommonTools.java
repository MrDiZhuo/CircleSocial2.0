package com.zwd.circlesocial20.adapter;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zwd.circlesocial20.R;

public class CommonTools {

	/**
	 * 获取默认头像参数
	 */
	public static DisplayImageOptions defaultImgOption;


	public static DisplayImageOptions getDefaultImgOption() {
		if (null == defaultImgOption) {
			defaultImgOption = new DisplayImageOptions.Builder()
					.showStubImage(R.drawable.ic_launcher)
					// 加载开始默认的图片
					.showImageForEmptyUri(R.drawable.ic_launcher)
					// url爲空會显示该图片，自己放在drawable里面的
					.showImageOnFail(R.drawable.ic_launcher)
					// 加载图片出现问题，会显示该图片
					.cacheInMemory()
					// 缓存用
					.cacheOnDisc()
					// 缓存用
					.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
					.considerExifParams(true).build();
		}
		return defaultImgOption;
	}

	public static DisplayImageOptions getDefaultImgOptionRounded() {
		if (null == defaultImgOption) {
			defaultImgOption = new DisplayImageOptions.Builder()
					.showStubImage(R.drawable.ic_launcher)
					// 加载开始默认的图片
					.showImageForEmptyUri(R.drawable.ic_launcher)
					// url爲空會显示该图片，自己放在drawable里面的
					.showImageOnFail(R.drawable.ic_launcher)
					// 加载图片出现问题，会显示该图片
					.cacheInMemory()
					// 缓存用
					.cacheOnDisc()
					// 缓存用
					.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
					.considerExifParams(true)
					.displayer(new RoundedBitmapDisplayer(50)).build();
		}
		return defaultImgOption;
	}
}
