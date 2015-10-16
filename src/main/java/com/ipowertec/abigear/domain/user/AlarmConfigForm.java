package com.ipowertec.abigear.domain.user;

public class AlarmConfigForm {
	
	private String dev_id;
	private String user_id;
	private String state;
	private String res_id;
	private String id;
	private AlarmConfig alarmcfg;
	
	
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String dev_id) {
		this.dev_id = dev_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AlarmConfig getAlarmcfg() {
		return alarmcfg;
	}
	public void setAlarmcfg(AlarmConfig alarmcfg) {
		this.alarmcfg = alarmcfg;
	}
	
}
