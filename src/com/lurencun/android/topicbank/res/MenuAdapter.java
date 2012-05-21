/**
 * 
 */
package com.lurencun.android.topicbank.res;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.MenuEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-2-24
 */
public class MenuAdapter extends CommonAdapter<MenuEntity> {

	public MenuAdapter(Context context) {
		super(context);
	}

	@Override
	protected View createView(LayoutInflater inflater, MenuEntity data,
			int position, View convertView, ViewGroup parent) {
		RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.menu_cell, null);
		ImageView icon = (ImageView)view.findViewById(R.id.menu_icon);
		TextView title = (TextView)view.findViewById(R.id.menu_title);
		icon.setImageBitmap(data.icon);
		title.setText(data.title);
		return view;
	}

}
