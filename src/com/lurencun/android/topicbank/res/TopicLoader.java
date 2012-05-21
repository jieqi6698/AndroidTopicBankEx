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
import com.lurencun.android.topicbank.entity.AnswerEntity;
import com.lurencun.android.topicbank.entity.TopicEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-6
 */
public class TopicLoader extends HasContext {

	/**
	 * @param context
	 */
	public TopicLoader(Context context) {
		super(context);
	}
	
	public List<TopicEntity> load(){
		int size = 100;
		List<TopicEntity> list = new ArrayList<TopicEntity>();
		for(int i=0;i<size;i++){
			TopicEntity topic = new TopicEntity();
			topic.index = i;
			
			topic.title = "题目内容题目内容题目内容题目内容题目内容题目内容";
			topic.tip = "青年毛泽东对新文化运动主将胡适很尊重仰慕，与他有不少交往，也受到他的一些进步思想的影响。1918年8月19日，毛泽东应读师范时的老师、时任北大教授的杨昌济之召来到北京，被推荐到北大图书馆做助理员的工作。";
			int answerCount = 4;
			if(i<3){
				topic.image = "demo_0.jpg" ;
				topic.type = TopicEntity.TopicType.SINGLE_CHOICE;
			}else if(i>=3 && i<6){
				topic.image = "demo_1.jpg" ;
				topic.type = TopicEntity.TopicType.MULTIPLE_CHOICE;
			}else{
				answerCount = 2;
				topic.image = "demo_2.jpg" ;
				topic.type = TopicEntity.TopicType.JUDGE;
			}
			
			for(int j=0;j<answerCount;j++){
				AnswerEntity answer = new AnswerEntity();
				answer.content = "答案选项内容答案选项内容答案选项内容答案选项内容";
				topic.answers.add(answer);
			}
			
			list.add(topic);
		}
		return list;
	}

}
