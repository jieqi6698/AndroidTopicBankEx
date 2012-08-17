/**
 * 
 */
package com.lurencun.android.topicbank.res;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.lurencun.android.toolkit.res.AssetsReader;
import com.lurencun.android.toolkit.res.ResJSONHandler;
import com.lurencun.android.topicbank.entity.MenuEntity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-2-24
 */
public class MenuLoader extends ResJSONHandler<MenuEntity>{

	private String mAppPackage;
	public MenuLoader(Context context) {
		super(context);
		mAppPackage = mContext.getPackageName();
	}

	@Override
	protected MenuEntity convert(JSONObject json) throws JSONException {
		MenuEntity menu = new MenuEntity();
		menu.icon = AssetsReader.readBitmap(mContext, json.getString("icon"));
		menu.title = json.getString("title");
		menu.value = json.getInt("value");
		try {
			String className = mAppPackage + json.getString("activity");
			menu.nextUI = Class.forName(className);
		} catch (ClassNotFoundException e) {
			menu.nextUI = null;
		}
		return menu;
	}
}
