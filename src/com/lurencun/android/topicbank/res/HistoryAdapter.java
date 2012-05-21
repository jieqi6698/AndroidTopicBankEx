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
import com.lurencun.android.topicbank.entity.HistoryEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-7
 */
public class HistoryAdapter extends CommonAdapter<HistoryEntity> {

	/**
	 * @param context
	 */
	public HistoryAdapter(Context context) {
		super(context);
	}

	/* (non-Javadoc)
	 * @see com.lurencun.android.support.widget.CommonAdapter#createView(android.view.LayoutInflater, java.lang.Object, int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	protected View createView(LayoutInflater inflater, HistoryEntity data,
			int position, View convertView, ViewGroup parent) {
		RelativeLayout historyCell = (RelativeLayout) inflater.inflate(R.layout.history_cell, null);
		TextView title = (TextView)historyCell.findViewById(R.id.topic_title);
		TextView time = (TextView)historyCell.findViewById(R.id.topic_meta_time);
		TextView score = (TextView)historyCell.findViewById(R.id.topic_meta_score);
		TextView correct = (TextView)historyCell.findViewById(R.id.topic_meta_correct);
		TextView mistake = (TextView)historyCell.findViewById(R.id.topic_meta_mistake);
		
		title.setText(data.getTitle());
		time.setText(data.getTime());
		score.setText(data.getScore());
		correct.setText(data.getCorrect());
		mistake.setText(data.getMistake());
		return historyCell;
	}

}
