package com.ipowertec.abigear.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipowertec.abigear.domain.weixin.AccessToken;
import com.ipowertec.abigear.domain.weixin.UserInfo;
import com.ipowertec.abigear.domain.weixin.WeixinConstants;
import com.ipowertec.abigear.service.weixin.WeixinOAuth2Service;

@Controller
public class WeixinOAuth2Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinOAuth2Controller.class);

    @Autowired
    private WeixinOAuth2Service weixinOAuth2Service;

    @RequestMapping("/oauth2")
    public String autheticate(HttpServletRequest request) throws Exception {
        LOGGER.info("Weixin oauth2 starting ...");
        return weixinOAuth2Service.getOAuth2Url(request);
    }

    @RequestMapping("/userinfo")
    public ModelAndView getHomePage(HttpServletRequest request, @RequestParam String code) throws Exception {
        AccessToken accessToken = weixinOAuth2Service.getAccessToken(code);
        HttpSession session = request.getSession();
        
        UserInfo userInfo = null;
        if (accessToken != null && accessToken.getToken() != null) {
            userInfo = weixinOAuth2Service.getUserInfo(accessToken);

            /*
            String Userid = getMemberGuidByCode(accessToken.getToken(), code, WeixinConstants.AGENTID);
            if (Userid != null) {
                session.setAttribute("UserId", Userid);
            }
            */
        }
        // 这里简单处理,存储到session中
        //return "user";
        return new ModelAndView("home", "userInfo", userInfo);
    }
}
