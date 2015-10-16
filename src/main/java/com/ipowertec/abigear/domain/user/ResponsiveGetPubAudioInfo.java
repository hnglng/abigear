package com.ipowertec.abigear.domain.user;

import java.util.List;

public class ResponsiveGetPubAudioInfo {
	
	private String status;
	private String msg;
	private List<PubAudio> data;
	
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
	public List<PubAudio> getData() {
		return data;
	}
	public void setData(List<PubAudio> data) {
		this.data = data;
	}
	
}
