/**
 * 
 */
package com.lurencun.android.topicbank.res;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.CategoryEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-2-24
 */
public class CategoryAdapter extends CommonAdapter<CategoryEntity> {

	public CategoryAdapter(Context context) {
		super(context);
	}

	@Override
	protected View createView(LayoutInflater inflater, CategoryEntity data,
			int position, View convertView, ViewGroup parent) {
		RelativeLayout cell = (RelativeLayout) inflater.inflate(R.layout.category_cell, null);
		TextView title = (TextView)cell.findViewById(R.id.category_title);
//		TextView desc = (TextView)cell.findViewById(R.id.category_describe);
		
		title.setText(data.title);
//		desc.setText(data.describe);
		
		return cell;
	}

}
