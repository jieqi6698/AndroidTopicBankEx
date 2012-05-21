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
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-6
 */
public class TipDialog extends Dialog {

	private static final int BG_COLOR = 0xFF585858;
	private static final int MSG_BG_COLOR = 0xFF222222;
	private static final int MSG_TEXT_COLOR = 0xFFFFFFFF;
	private static final int SIDE_BTN_COLOR = 0xFFEEEEEE;
	private static final int BTN_TEXT_COLOR = 0xFF2587AD;
	private static final String OK_BTN_TEXT = "确定";
	private static final String CANCLE_BTN_TEXT = "取消";
	
	private Context mContext;
	private OnDialogListener mListener;
	private String mMessage;
	public TipDialog(Context context) {
		super(context, android.R.style.Theme_Dialog);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		mContext = context;
	}
	
	public void setODialogListener(OnDialogListener listener){
		mListener = listener;
	}
	

	public void setTipMsg(String msg){
		mMessage = msg;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(createContentView());
	}
	
	private View createContentView() {
		LinearLayout layout = new LinearLayout(mContext);
		layout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout.setLayoutParams(params);
		int padding = 10;
		layout.setPadding(padding, padding, padding, padding);
		layout.setBackgroundColor(BG_COLOR);
		TextView msgBox = new TextView(mContext);
		msgBox.setTextColor(MSG_TEXT_COLOR);
		msgBox.setPadding(padding, padding/2, padding, padding);
		msgBox.setBackgroundColor(MSG_BG_COLOR);
		msgBox.setText(mMessage);
		layout.addView(msgBox);
		LinearLayout buttonsLayout = new LinearLayout(mContext);
		buttonsLayout.setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams btnLayoutParam = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		btnLayoutParam.topMargin = 2;
		buttonsLayout.setLayoutParams(btnLayoutParam);
		Button okButton = new Button(mContext);
		Button cancleButton = new Button(mContext);
		
		LayoutParams btnParam = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		btnParam.weight = 1.0f;
		btnParam.rightMargin = 2;
		okButton.setLayoutParams(btnParam);
		okButton.setText(OK_BTN_TEXT);
		okButton.setTextColor(BTN_TEXT_COLOR);
		okButton.setBackgroundColor(SIDE_BTN_COLOR);
		okButton.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundColor(BTN_TEXT_COLOR);
					((Button)v).setTextColor(SIDE_BTN_COLOR);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundColor(SIDE_BTN_COLOR);
					((Button)v).setTextColor(BTN_TEXT_COLOR);
				}
				if(mListener != null)mListener.onOK();
				TipDialog.this.dismiss();
				return false;
			}
		});
		btnParam.leftMargin = 2;
		cancleButton.setLayoutParams(btnParam);
		cancleButton.setText(CANCLE_BTN_TEXT);
		cancleButton.setBackgroundColor(SIDE_BTN_COLOR);
		cancleButton.setTextColor(BTN_TEXT_COLOR);
		cancleButton.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					v.setBackgroundColor(BTN_TEXT_COLOR);
					((Button)v).setTextColor(SIDE_BTN_COLOR);
				}else if(event.getAction() == MotionEvent.ACTION_UP){
					v.setBackgroundColor(SIDE_BTN_COLOR);
					((Button)v).setTextColor(BTN_TEXT_COLOR);
				}
				if(mListener != null)mListener.onCancle();
				TipDialog.this.dismiss();
				return false;
			}
		});
		buttonsLayout.addView(okButton);
		buttonsLayout.addView(cancleButton);
		layout.addView(buttonsLayout);
		return layout;
	}
	
	

}
