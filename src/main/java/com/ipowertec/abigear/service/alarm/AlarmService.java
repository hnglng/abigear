package com.ipowertec.abigear.service.alarm;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.ipowertec.abigear.domain.user.Alarm;
import com.ipowertec.abigear.domain.user.AlarmConfig;
import com.ipowertec.abigear.domain.user.AlarmConfigForm;
import com.ipowertec.abigear.domain.user.Device;
import com.ipowertec.abigear.domain.user.User;
import com.ipowertec.abigear.domain.user.UserCreateForm;

@Service
public interface AlarmService {
	
	List<Device> getAllDevice(JSONObject userMail);
	
	List<List<Alarm>> getAllAlarm(List<Device> allDevice);
	
	String addAlarm(JSONObject alarmConfig);
	
	String editAlarm(JSONObject alarmConfig);

}
