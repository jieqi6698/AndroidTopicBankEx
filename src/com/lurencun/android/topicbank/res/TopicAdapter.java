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

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.lurencun.android.sdk.res.AssetsReader;
import com.lurencun.android.sdk.util.BitmapScaleUitl;
import com.lurencun.android.support.widget.CommonAdapter;
import com.lurencun.android.topicbank.AppSetting;
import com.lurencun.android.topicbank.R;
import com.lurencun.android.topicbank.entity.AnswerEntity;
import com.lurencun.android.topicbank.entity.TopicEntity;
import com.lurencun.android.topicbank.widget.ImageDialog;
import com.lurencun.android.topicbank.widget.TipDialog;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-6
 */
public class TopicAdapter extends CommonAdapter<TopicEntity> {

	private Vibrator mVirator;
	
	public TopicAdapter(Context context) {
		super(context);
		mVirator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
	}

	/* (non-Javadoc)
	 * @see com.lurencun.android.support.widget.CommonAdapter#createView(android.view.LayoutInflater, java.lang.Object, int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	protected View createView(LayoutInflater inflater, TopicEntity data,
			int position, View convertView, ViewGroup parent) {
		return null;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ScrollView  topicCell = (ScrollView) mInflater.inflate(R.layout.topic_cell, null);
		TextView index = (TextView)topicCell.findViewById(R.id.topic_index);
		TextView content = (TextView)topicCell.findViewById(R.id.topic_content);
		ImageView image = (ImageView)topicCell.findViewById(R.id.topic_imgs);
		LinearLayout answerLayout = (LinearLayout)topicCell.findViewById(R.id.topic_answer_layout);
		
		final TopicEntity topic = mDataCacheList.get(position);
		
		index.setText(String.format(AppSetting.TOPIC_INDEX, topic.index));
		content.setText(topic.title);
		createAnswerGroup(answerLayout,topic);
		Bitmap tempImage = BitmapScaleUitl.prorateThumbnail(AssetsReader.readBitmap(mContext, topic.image), 120, 60);
		if(tempImage.getHeight() > tempImage.getWidth()){
			Matrix matrix = new Matrix();  
			matrix.postRotate(90);  
			tempImage = Bitmap.createBitmap(tempImage, 0, 0, tempImage.getWidth(), tempImage.getHeight(), matrix, true); 
		}
		image.setImageBitmap(tempImage);
		Button addFavourite = (Button)topicCell.findViewById(R.id.topic_answer_add_fav);
		addFavourite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "已将题目添加到收藏夹中！", Toast.LENGTH_SHORT).show();
			}
		});
		Button viewAnswer = (Button)topicCell.findViewById(R.id.topic_answer_view);
		
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageDialog dialog = new ImageDialog(mContext);
				Bitmap tempImage = AssetsReader.readBitmap(mContext, topic.image);
				if(tempImage.getWidth() > tempImage.getHeight()){
					Matrix matrix = new Matrix();  
					matrix.postRotate(90);  
					tempImage = Bitmap.createBitmap(tempImage, 0, 0, tempImage.getWidth(), tempImage.getHeight(), matrix, true); 
				}
				dialog.setImage(tempImage);
				dialog.show();
			}
		});
		viewAnswer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TipDialog mTipDialog = new TipDialog(mContext);
				mTipDialog.setTipMsg(topic.tip);
				mTipDialog.show();
			}
		});
		return topicCell;
	}
	
	private void createAnswerGroup(LinearLayout answerLayout,TopicEntity topic){
		if(topic.type.equals(TopicEntity.TopicType.JUDGE)){
			createJudgeView(answerLayout,topic);
		}else if(topic.type.equals(TopicEntity.TopicType.MULTIPLE_CHOICE)){
			createMultipleChoiceView(answerLayout,topic);
		}else{
			createSingleChoiceView(answerLayout,topic);
		}
	}
	
	/**
	 * 创建判断题答案组
	 * @param answerLayout
	 * @param topic
	 */
	private void createJudgeView(LinearLayout answerLayout,TopicEntity topic){
		List<AnswerEntity> answerSet = topic.answers;
		answerLayout.setOrientation(LinearLayout.HORIZONTAL);
		if(answerSet.size() == 2){
			RelativeLayout trueSelection = (RelativeLayout) mInflater.inflate(R.layout.answer_judge_cell, null);
			RelativeLayout falseSelection = (RelativeLayout) mInflater.inflate(R.layout.answer_judge_cell, null);
			LayoutParams btnParam = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			btnParam.weight = 1.0f;
			trueSelection.setLayoutParams(btnParam);
			falseSelection.setLayoutParams(btnParam);
			
			final ImageView trueIcon = (ImageView)trueSelection.findViewById(R.id.answer_icon);
			final ImageView falseIcon = (ImageView)falseSelection.findViewById(R.id.answer_icon);
			final int trueIndex = 0;
			final int falseIndex = 1;
			final AnswerEntity trueEntity = answerSet.get(trueIndex);
			final AnswerEntity falseEntity = answerSet.get(trueIndex);
			int trueIconResId = trueEntity.isChecked ? AppSetting.AnswerIcons.Judge.PRESSED_ARRAY[trueIndex] :
				AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[trueIndex];
			int falseIconResId = falseEntity.isChecked ? AppSetting.AnswerIcons.Judge.PRESSED_ARRAY[falseIndex] :
				AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[falseIndex];
			trueIcon.setImageResource(trueIconResId);
			falseIcon.setImageResource(falseIconResId);
			
			trueSelection.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mVirator.vibrate(AppSetting.VIRATOR_PARAMS, -1);
					trueEntity.isChecked = !trueEntity.isChecked;
					int iconResId = trueEntity.isChecked ? AppSetting.AnswerIcons.Judge.PRESSED_ARRAY[trueIndex] :
						AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[trueIndex];
					trueIcon.setImageResource(iconResId);
					if(trueEntity.isChecked){
						falseEntity.isChecked = false;
						int releaseIconResId = AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[falseIndex];
						falseIcon.setImageResource(releaseIconResId);
					}
				}
			});
			
			falseSelection.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mVirator.vibrate(AppSetting.VIRATOR_PARAMS, -1);
					falseEntity.isChecked = !falseEntity.isChecked;
					int iconResId = falseEntity.isChecked ? AppSetting.AnswerIcons.Judge.PRESSED_ARRAY[falseIndex] :
						AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[falseIndex];
					falseIcon.setImageResource(iconResId);
					if(falseEntity.isChecked){
						trueEntity.isChecked = false;
						int releaseIconResId = AppSetting.AnswerIcons.Judge.NORMAL_ARRAY[trueIndex];
						trueIcon.setImageResource(releaseIconResId);
					}
				}
			});
			
			answerLayout.addView(trueSelection);
			answerLayout.addView(falseSelection);
		}else{
			Log.e("E","判断题只能有两答案选项！");
		}
	}
	
	/**
	 * 创建多选答案组
	 * @param answerLayout
	 * @param topic
	 */
	private void createMultipleChoiceView(LinearLayout answerLayout,TopicEntity topic){
		List<AnswerEntity> answerSet = topic.answers;
		for(int i=0;i<answerSet.size();i++){
			RelativeLayout answer = (RelativeLayout) mInflater.inflate(R.layout.answer_selection_cell, null);
			final ImageView icon = (ImageView)answer.findViewById(R.id.answer_icon);
			TextView content = (TextView)answer.findViewById(R.id.answer_content);
			final AnswerEntity answerEntity = answerSet.get(i);
			int iconResId = answerEntity.isChecked ? AppSetting.AnswerIcons.MultipleChoice.PRESSED[i] :
				AppSetting.AnswerIcons.MultipleChoice.NORMAL_ARRAY[i];
			icon.setImageResource(iconResId);
			content.setText(answerEntity.content);
			answerLayout.addView(answer);
			final int index = i;
			answer.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mVirator.vibrate(AppSetting.VIRATOR_PARAMS, -1);
					answerEntity.isChecked = !answerEntity.isChecked;
					int iconResId = answerEntity.isChecked ? AppSetting.AnswerIcons.MultipleChoice.PRESSED[index] :
						AppSetting.AnswerIcons.MultipleChoice.NORMAL_ARRAY[index];
					icon.setImageResource(iconResId);
				}
			});
		}
	}
	
	/**
	 * 创建单选答案组
	 * @param answerLayout
	 * @param topic
	 */
	private void createSingleChoiceView(LinearLayout answerLayout,TopicEntity topic){
		final List<AnswerEntity> answerSet = topic.answers;
		final int size = answerSet.size();
		final ImageView[] tempIconArray = new ImageView[size];
		for(int i=0;i<size;i++){
			RelativeLayout answer = (RelativeLayout) mInflater.inflate(R.layout.answer_selection_cell, null);
			final ImageView icon = (ImageView)answer.findViewById(R.id.answer_icon);
			tempIconArray[i] = icon;
			TextView content = (TextView)answer.findViewById(R.id.answer_content);
			final AnswerEntity answerEntity = answerSet.get(i);
			int iconResId = answerEntity.isChecked ? AppSetting.AnswerIcons.SingleChoice.PRESSED[i] :
				AppSetting.AnswerIcons.SingleChoice.NORMAL_ARRAY[i];
			icon.setImageResource(iconResId);
			content.setText(answerEntity.content);
			answerLayout.addView(answer);
			
			final int index = i;
			answer.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mVirator.vibrate(AppSetting.VIRATOR_PARAMS, -1);
					answerEntity.isChecked = !answerEntity.isChecked;
					int iconResId = answerEntity.isChecked ? AppSetting.AnswerIcons.SingleChoice.PRESSED[index] :
						AppSetting.AnswerIcons.SingleChoice.NORMAL_ARRAY[index];
					for(int i=0;i<size;i++){
						tempIconArray[i].setImageResource(AppSetting.AnswerIcons.SingleChoice.NORMAL_ARRAY[i]);
						answerSet.get(i).isChecked = false;
					}
					icon.setImageResource(iconResId);
				}
			});
		}
	}
	
}
