package com.ipowertec.abigear.domain.user;

/**
 * 用户绑定的某个设备信息
 * @author Administrator
 *
 */
public class Device {
	
	private String user_id;
	private String hb_at;
	private String bind_at;
	private String created_at;
	private String soft_ver;
	private String mac;
	private String hard_ver;
	private String id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHb_at() {
		return hb_at;
	}
	public void setHb_at(String hb_at) {
		this.hb_at = hb_at;
	}
	public String getBind_at() {
		return bind_at;
	}
	public void setBind_at(String bind_at) {
		this.bind_at = bind_at;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getSoft_ver() {
		return soft_ver;
	}
	public void setSoft_ver(String soft_ver) {
		this.soft_ver = soft_ver;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getHard_ver() {
		return hard_ver;
	}
	public void setHard_ver(String hard_ver) {
		this.hard_ver = hard_ver;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
