package com.ipowertec.abigear.domain.user;

/**
 * 设备上的闹钟信息
 * @author Administrator
 *
 */
public class Alarm {
	
	private String dev_id;
	private String user_id;
	private String created_at;
	private String updated_at;
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
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
