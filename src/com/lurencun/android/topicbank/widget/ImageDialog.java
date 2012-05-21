/**
 * Copyright (C) 2012  TopicBankEx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lurencun.android.topicbank.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.lurencun.android.support.v2.widget.ImageViewTouch;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-6
 */
public class ImageDialog extends Dialog {

	private static final int BG_COLOR = 0xFF333333;
	private static final int MSG_BG_COLOR = 0x66222222;

	private static final String TIP_MSG = "进入【图像缩放模式】，把返回键退出。";
	private static final String OP_TIP_MSG = "操作：1、双指缩放图像 2、单指拖动图像 3、双击自动缩放";
	
	private Context mContext;
	private Bitmap mImage;
	
	public ImageDialog(Context context) {
		super(context, android.R.style.Theme_NoTitleBar);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		mContext = context;
	}

	public void setImage(Bitmap image){
		mImage = image;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(createContentView());
	}
	
	private View createContentView() {
		RelativeLayout layout = new RelativeLayout(mContext);
		layout.setBackgroundColor(BG_COLOR);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		TextView tip = new TextView(mContext);
		tip.setBackgroundColor(MSG_BG_COLOR);
		tip.setText(TIP_MSG);
		tip.setTextColor(0xFFFFFFFF);
		tip.setPadding(0, 5, 0, 5);
		tip.setGravity(Gravity.CENTER_HORIZONTAL);
		
		LayoutParams opParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		opParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		TextView opTip = new TextView(mContext);
		opTip.setBackgroundColor(MSG_BG_COLOR);
		opTip.setText(OP_TIP_MSG);
		opTip.setTextSize(12);
		opTip.setTextColor(0xFFFFFFFF);
		opTip.setPadding(0, 5, 0, 5);
		opTip.setGravity(Gravity.CENTER_HORIZONTAL);
		
		LayoutParams imgParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		imgParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		ImageViewTouch imageView = new ImageViewTouch(mContext);
		imageView.setImageBitmap(mImage);
		imageView.setImageBitmapReset(mImage, true);
		layout.addView(imageView,imgParams);
		layout.addView(tip,params);
		layout.addView(opTip,opParams);
		return layout;
	}
	
	

}
