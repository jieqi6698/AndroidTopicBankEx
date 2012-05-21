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
package com.lurencun.android.topicbank.entity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@163.com)
 * @date 2012-3-7
 */
public class HistoryEntity {
	private final static String SCORE_TIP = "得分：%d";
	private final static String CORRECT_TIP = "正确：%d";
	private final static String MISTAKE_TIP = "错误：%d";
	
	private String title;
	private int topic;
	private String time;
	private int score;
	private int correct;
	private int mistake;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTopic() {
		return topic;
	}
	public void setTopic(int topic) {
		this.topic = topic;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getScore() {
		return String.format(SCORE_TIP, score);
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCorrect() {
		return String.format(CORRECT_TIP, correct);
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public String getMistake() {
		return String.format(MISTAKE_TIP, mistake);
	}
	public void setMistake(int mistake) {
		this.mistake = mistake;
	}
	
}
