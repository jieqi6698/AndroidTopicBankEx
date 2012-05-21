/**
 * 
 */
package com.lurencun.android.topicbank.res;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.lurencun.android.sdk.HasContext;
import com.lurencun.android.topicbank.entity.CategoryEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-2-24
 */
public class CategoryLoader extends HasContext {

	public CategoryLoader(Context context) {
		super(context);
	}
	
	public List<CategoryEntity> load(int type){
		int size = 30;
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		for(int i=0;i<size;i++){
			CategoryEntity item = new CategoryEntity();
			item.describe = "2012年计算机等级考试（二级）模拟试题，包含答案！";
			item.title = "计算机等级考试（二级)模拟";
			list.add(item);
		}
		return list;
	}

}
