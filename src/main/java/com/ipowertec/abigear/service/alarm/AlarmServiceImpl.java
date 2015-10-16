package com.ipowertec.abigear.service.alarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipowertec.abigear.domain.user.Alarm;
import com.ipowertec.abigear.domain.user.Device;
import com.ipowertec.abigear.domain.user.PubAudio;
import com.ipowertec.abigear.domain.user.ResponsiveGetAlarmInfo;
import com.ipowertec.abigear.domain.user.ResponsiveGetDeviceInfo;
import com.ipowertec.abigear.domain.user.ResponsiveGetPubAudioInfo;
import com.ipowertec.abigear.infrastructure.httpclient.AlarmHttpClient;

@Service
public class AlarmServiceImpl implements AlarmService{
	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmServiceImpl.class);
	
	private final String URL4GET_DEVICE = "http://120.25.239.73:5000/api?method=get_device";
	private final String URL4GET_ALARM = "http://120.25.239.73:5000/api?method=get_alarm";
	private final String URL4SET_ALARM = "http://120.25.239.73:5000/api?method=set_alarm";
	private final String URL4GET_PUB_AUDIO = "http://120.25.239.73:5000/api?method=get_pub_audio";
	
	@Autowired
    private AlarmHttpClient alarmHttpClient;

	@Override
	public List<Device> getAllDevice(JSONObject userMail) {
		String deviceMessage = null;
		try {
			deviceMessage = alarmHttpClient.sendHttpPost(URL4GET_DEVICE, userMail);
		} catch (Exception e) {
			LOGGER.error("Call Get_device failed.", e);
		}
    	LOGGER.debug("Call Get_device Return Information:" + deviceMessage);
    	
    	System.err.println(deviceMessage);
    	
    	Map<String, Class<Device>> device = new HashMap<String, Class<Device>>();  
    	device.put("data", Device.class);
    	ResponsiveGetDeviceInfo responsiveGetDeviceInfo = (ResponsiveGetDeviceInfo)JSONObject.toBean(JSONObject.fromObject(deviceMessage), ResponsiveGetDeviceInfo.class, device);
    	
    	System.err.println(responsiveGetDeviceInfo.getMsg());
    	
		return responsiveGetDeviceInfo.getData();
	}

	@Override
	public List<List<Alarm>> getAllAlarm(List<Device> allDevice) {
		List<List<Alarm>> allAlarm = new ArrayList<List<Alarm>>();
		for (Device singleDevice : allDevice) {
    		JSONObject mac = new JSONObject();
    		mac.put("mac", singleDevice.getMac());
        	String alarmListInfo = null;
			try {
				alarmListInfo = alarmHttpClient.sendHttpPost(URL4GET_ALARM, mac);
			} catch (Exception e) {
				LOGGER.error("Call Get_alarm failed.", e);
			}
        	LOGGER.debug("Call Get_alarm Return Information:" + alarmListInfo);
        	
        	System.err.println(Arrays.toString(JSONObject.fromObject(alarmListInfo).getJSONArray("data").toArray()));
        	System.err.println("alarmListInfo  ==>"+alarmListInfo);
        	
        	Map<String, Class<Alarm>> alarm = new HashMap<String, Class<Alarm>>();  
        	alarm.put("data", Alarm.class);
        	ResponsiveGetAlarmInfo responsiveGetAlarmInfo = (ResponsiveGetAlarmInfo)JSONObject.toBean(JSONObject.fromObject(alarmListInfo), ResponsiveGetAlarmInfo.class, alarm);
        	
        	System.err.println("alarmList  ==>"+responsiveGetAlarmInfo.getData().get(1).getCreated_at());
        	
        	allAlarm.add(responsiveGetAlarmInfo.getData());
		}
		return allAlarm;
	}
	
	@Override
	public List<PubAudio> getAllPubAudio(JSONObject requestInfo) {
		String pubAudioInfo = null;
		try {
			pubAudioInfo = alarmHttpClient.sendHttpPost(URL4GET_PUB_AUDIO, requestInfo);
		} catch (Exception e) {
			LOGGER.error("Call Get_PUB_AUDIO failed.", e);
		}
    	LOGGER.debug("Call Get_PUB_AUDIO Return Information:" + pubAudioInfo);
    	
    	System.err.println(pubAudioInfo);
    	
    	Map<String, Class<PubAudio>> pubAudio = new HashMap<String, Class<PubAudio>>();  
    	pubAudio.put("data", PubAudio.class);
    	ResponsiveGetPubAudioInfo responsiveGetPubAudioInfo = (ResponsiveGetPubAudioInfo)JSONObject.toBean(JSONObject.fromObject(pubAudioInfo), ResponsiveGetPubAudioInfo.class, pubAudio);
    	
    	System.err.println(responsiveGetPubAudioInfo.getMsg());
    	
		return responsiveGetPubAudioInfo.getData();
	}

	@Override
	public String addAlarm(JSONObject alarmConfig) {
		String returnMessage = null;
		try {
			returnMessage = alarmHttpClient.sendHttpPost(URL4SET_ALARM, alarmConfig);
		} catch (Exception e) {
			LOGGER.error("Call Set_alarm failed.", e);
		}
    	LOGGER.debug("Call addAlarm Return Information:" + returnMessage);
		return returnMessage;
	}

	@Override
	public String editAlarm(JSONObject alarmConfig) {
		String returnMessage = null;
		try {
			returnMessage = alarmHttpClient.sendHttpPost(URL4SET_ALARM, alarmConfig);
		} catch (Exception e) {
			LOGGER.error("Call Set_alarm failed.", e);
		}
    	LOGGER.debug("Call editAlarm Return Information:" + returnMessage);
		return returnMessage;
	}

}
