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
package com.lurencun.android.topicbank.ui;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.lurencun.android.support.ui.BackUIActivity;
import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.support.widget.GalleryFlipper;
import com.lurencun.android.topicbank.AppSetting;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.TopicEntity;
import com.lurencun.android.topicbank.res.TopicAdapter;
import com.lurencun.android.topicbank.res.TopicLoader;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-6
 */
public class TopicActivity extends BackUIActivity {

	private GalleryFlipper mGallery;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGallery.onFlipperTouchEvent(event);
	}
	
	@Override
	protected void overridePendingTransition(Activity activity){
		activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}

	@Override
	protected void onCreateEx(Bundle savedInstanceState) {
		mGallery = (GalleryFlipper)findViewById(R.id.topic_container);
		mGallery.setAnimationDuration(300);
		CommonAdapter<TopicEntity> adapter = new TopicAdapter(this);
		List<TopicEntity> data = new TopicLoader(this).load();
		adapter.updateDataCache(data);
		mGallery.setAdapter(adapter);
		mGallery.isGalleryCircular(false);
	}

	@Override
	protected int getContentViewLayoutId() {
		return R.layout.topic;
	}

	@Override
	protected int getBackButtonResId() {
		return R.id.back_button;
	}

	@Override
	protected boolean isConfirmBack() {
		return true;
	}
	
	@Override
	protected String getTipMessage(){
		return AppSetting.TOPIC_BACK_TIP;
	}
	
	
	
}
