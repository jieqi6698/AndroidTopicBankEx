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
package com.lurencun.android.topicbank.res;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.ResultEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-9
 */
public class SearchAdapter extends CommonAdapter<ResultEntity> {

	/**
	 * @param context
	 */
	public SearchAdapter(Context context) {
		super(context);
	}

	@Override
	protected View createView(LayoutInflater inflater, ResultEntity data,
			int position, View convertView, ViewGroup parent) {
		RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.search_cell, null);
		TextView title = (TextView)layout.findViewById(R.id.result_title);
		TextView summary = (TextView)layout.findViewById(R.id.result_summary);
		
		title.setText(data.title);
		summary.setText(data.summary);
		
		return layout;
	}

}
