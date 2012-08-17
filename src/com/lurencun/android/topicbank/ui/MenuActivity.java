package com.lurencun.android.topicbank.ui;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.lurencun.android.support.ui.BaseActivity;
import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.toolkit.util.ActivitySwitcher;
import com.lurencun.android.topicbank.AppSetting;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.MenuEntity;
import com.lurencun.android.topicbank.res.MenuAdapter;
import com.lurencun.android.topicbank.res.MenuLoader;

public class MenuActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	this.hideTitleBar();
    	this.bindDoubleClickExit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bind();
    }
    
    private void bind(){
    	GridView grid = (GridView)findViewById(R.id.menu_grid);
    	CommonAdapter<MenuEntity> adapter = new MenuAdapter(this);
    	final List<MenuEntity> data = new MenuLoader(this).load(R.array.menu_config);
    	adapter.updateDataCache(data);
    	grid.setAdapter(adapter);
    	
    	grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				MenuEntity menu = data.get(position);
				if(menu.value == 0){ //搜索
					onSearchRequested();
				}else{
					String[] keys = new String[]{AppSetting.MENU_KEY,AppSetting.MENU_TITLE};
					Object[] vals = new Object[]{menu.value,menu.title};
					ActivitySwitcher.switchTo(MenuActivity.this, menu.nextUI,keys,vals);
				}
				
			}
    		
		});
    }
}