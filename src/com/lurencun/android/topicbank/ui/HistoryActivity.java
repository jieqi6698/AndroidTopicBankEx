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
package com.lurencun.android.topicbank.ui;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.lurencun.android.support.ui.BackUIActivity;
import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.HistoryEntity;
import com.lurencun.android.topicbank.res.HistoryAdapter;
import com.lurencun.android.topicbank.res.HistoryLoader;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-7
 */
public class HistoryActivity extends BackUIActivity {

	@Override
	protected void onCreateEx(Bundle savedInstanceState) {
		ListView list = (ListView)findViewById(R.id.list_container);
		CommonAdapter<HistoryEntity> adapter = new HistoryAdapter(this);
		final List<HistoryEntity> data = new HistoryLoader(this).load();
		adapter.updateDataCache(data);
		list.setAdapter(adapter);
	}

	@Override
	protected int getContentViewLayoutId() {
		return R.layout.history;
	}

	@Override
	protected int getBackButtonResId() {
		return R.id.back_button;
	}

	@Override
	protected boolean isConfirmBack() {
		return false;
	}

}
