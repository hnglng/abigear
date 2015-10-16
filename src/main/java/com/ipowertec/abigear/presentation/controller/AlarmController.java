package com.ipowertec.abigear.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipowertec.abigear.domain.user.Alarm;
import com.ipowertec.abigear.domain.user.Device;
import com.ipowertec.abigear.domain.user.PubAudio;
import com.ipowertec.abigear.service.alarm.AlarmService;

@Controller
public class AlarmController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class);
    
    @Autowired
    private AlarmService alarmService;
    
    @RequestMapping("/alarm/getalarm/{user_mail}")
    public ModelAndView getAlarm(@PathVariable("user_mail") String user_mail) {
        LOGGER.debug("Getting alarm page");
        
        JSONObject requestInfo = new JSONObject();
        requestInfo.put("user_mail", user_mail);
        List<Device> allDevice = alarmService.getAllDevice(requestInfo);
        List<List<Alarm>> allAlarm = alarmService.getAllAlarm(allDevice);
        
        if(null == allAlarm || allAlarm.isEmpty()){
        	return new ModelAndView("noalarm");
        } else {
        	Map<String, List<List<Alarm>>> map = new HashMap<String, List<List<Alarm>>>();
        	map.put("allAlarm", allAlarm);
        	return new ModelAndView("setalarm", map);
        }
    }
    
    @RequestMapping("/alarm/getpubaudio")
    public ModelAndView getPubAudio(HttpServletRequest request) {
    	String client_type = "user";
    	String user_name = "test@hifi.com";
        JSONObject requestInfo = new JSONObject();
        requestInfo.put("client_type", client_type);
        requestInfo.put("user_name", user_name);
        List<PubAudio> allPubAudio = alarmService.getAllPubAudio(requestInfo);
        System.out.println(allPubAudio.get(0).getRes_md5());
    	Map<String, List<PubAudio>> map = new HashMap<String, List<PubAudio>>();
    	map.put("allAlarm", allPubAudio);
    	return new ModelAndView("", map);
    }
    
    @RequestMapping("/alarm/addalarm")
    public String addAlarm(HttpServletRequest request) {
    	JSONObject alarmConfig = new JSONObject();
    	alarmConfig.put("id", 0);//id  0 创建新闹钟，大于0 更新某闹钟
    	alarmConfig.put("user_id", 6);
    	alarmConfig.put("dev_id", 8);
    	alarmConfig.put("res_id", 2);
    	alarmConfig.put("state", 1);
    	alarmConfig.put("alarmcfg", "{'call_at':'15:05','week':[1,2,3,4,5], 'repeat':5,   'continue_time':30,  'blank_time':30}");
		String a = alarmService.addAlarm(alarmConfig);
		System.out.println(a);

        return "";
    }
    
    @RequestMapping("/alarm/editalarm")
    public ModelAndView editAlarm(HttpServletRequest request, @RequestParam String alarmId) {
    	JSONObject alarmConfig = new JSONObject();
    	alarmConfig.put("id", 14);//id  0 创建新闹钟，大于0 更新某闹钟
    	alarmConfig.put("user_id", 6);
    	alarmConfig.put("dev_id", 8);
    	alarmConfig.put("res_id", 2);
    	alarmConfig.put("state", 1);
    	alarmConfig.put("alarmcfg", "{'call_at':'15:05','week':[1,2,3,4,5], 'repeat':5,   'continue_time':30,  'blank_time':30}");
    	alarmService.editAlarm(alarmConfig);
        return new ModelAndView("");
    }
    
    @RequestMapping("/alarm/deletealarm")
    public ModelAndView deleteAlarm(HttpServletRequest request, @RequestParam String alarmId) {
    	
        return new ModelAndView("");
    }
}
