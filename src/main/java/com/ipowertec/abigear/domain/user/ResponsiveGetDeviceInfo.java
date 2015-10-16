package com.ipowertec.abigear.domain.user;

import java.util.List;

/**
 * 用户绑定的所有设备信息集合
 * @author Administrator
 *
 */
public class ResponsiveGetDeviceInfo {
	
	private String status;
	private String msg;
	
	private List<Device> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public List<Device> getData() {
		return data;
	}

	public void setData(List<Device> data) {
		this.data = data;
	}

}
