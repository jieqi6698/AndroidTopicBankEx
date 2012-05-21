/**
 * 
 */
package com.lurencun.android.topicbank.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.lurencun.android.sdk.util.ActivitySwitcher;
import com.lurencun.android.support.ui.BackUIActivity;
import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.AppSetting;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.CategoryEntity;
import com.lurencun.android.topicbank.res.CategoryAdapter;
import com.lurencun.android.topicbank.res.CategoryLoader;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-2-24
 */
public class CategoryActivity extends BackUIActivity {

	@Override
	protected void onCreateEx(Bundle savedInstanceState) {
		Intent intent = getIntent();
		String title = intent.getStringExtra(AppSetting.MENU_TITLE);
		int value = intent.getIntExtra(AppSetting.MENU_KEY, 0);
		
		TextView titleView = (TextView) findViewById(R.id.app_title);
		titleView.setText(title);
		
		ListView list = (ListView)findViewById(R.id.list_container);
		CommonAdapter<CategoryEntity> adapter = new CategoryAdapter(this);
		final List<CategoryEntity> data = new CategoryLoader(this).load(value);
		adapter.updateDataCache(data);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ActivitySwitcher.switchTo(CategoryActivity.this, ExtraTopicActivity.class);
			}
		});
	}

	@Override
	protected int getContentViewLayoutId() {
		return R.layout.category;
	}

	@Override
	protected int getBackButtonResId() {
		return R.id.back_button;
	}

	@Override
	protected boolean isConfirmBack() {
		return false;
	}

}
