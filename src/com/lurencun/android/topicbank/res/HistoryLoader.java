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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.lurencun.android.sdk.HasContext;
import com.lurencun.android.topicbank.entity.HistoryEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-7
 */
public class HistoryLoader extends HasContext {

	/**
	 * @param context
	 */
	public HistoryLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public List<HistoryEntity> load(){
		List<HistoryEntity> data = new ArrayList<HistoryEntity>();
		int size = 10;
		for(int i=0;i<size;i++){
			HistoryEntity history = new HistoryEntity();
			history.setTitle("历史记录第（"+i+"）条记录");
			history.setScore(100);
			history.setMistake(20);
			history.setTime("2012-3-7 12:59:60");
			history.setTopic(i);
			data.add(history);
		}
		return data;
	}

}
