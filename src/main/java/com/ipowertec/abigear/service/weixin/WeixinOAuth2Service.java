package com.ipowertec.abigear.service.weixin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ipowertec.abigear.domain.weixin.AccessToken;
import com.ipowertec.abigear.domain.weixin.UserInfo;

@Service
public interface WeixinOAuth2Service {
    public String getOAuth2Url(HttpServletRequest request) throws Exception;    
    public AccessToken getAccessToken(String code) throws Exception;
    public UserInfo getUserInfo(AccessToken accessToken) throws Exception;
}
