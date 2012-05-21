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
import com.lurencun.android.topicbank.entity.ResultEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-9
 */
public class SearchLoader extends HasContext {

	/**
	 * @param context
	 */
	public SearchLoader(Context context) {
		super(context);
	}
	
	public List<ResultEntity> search(String keyword){
		List<ResultEntity> result = new ArrayList<ResultEntity>();
		int size = 10;
		for(int i=0;i<size;i++){
			ResultEntity re = new ResultEntity();
			re.title = "搜索关键字《"+keyword+"》标题";
			re.summary = "这是一个关于搜索关键字《"+keyword+"》结果的描述信息";
			result.add(re);
		}
		return result;
	}

}
