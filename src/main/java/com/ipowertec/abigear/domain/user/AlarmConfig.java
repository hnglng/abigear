package com.ipowertec.abigear.domain.user;

import net.sf.json.JSONArray;

/**
 * 闹钟的配置信息
 * @author Administrator
 *
 */
public class AlarmConfig {
	
	private JSONArray week;
	private String continue_time;
	private String repeat;
	private String blank_time;
	private String call_at;
	
	public JSONArray getWeek() {
		return week;
	}
	public void setWeek(JSONArray week) {
		this.week = week;
	}
	public String getContinue_time() {
		return continue_time;
	}
	public void setContinue_time(String continue_time) {
		this.continue_time = continue_time;
	}
	public String getRepeat() {
		return repeat;
	}
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}
	public String getBlank_time() {
		return blank_time;
	}
	public void setBlank_time(String blank_time) {
		this.blank_time = blank_time;
	}
	public String getCall_at() {
		return call_at;
	}
	public void setCall_at(String call_at) {
		this.call_at = call_at;
	}
}
