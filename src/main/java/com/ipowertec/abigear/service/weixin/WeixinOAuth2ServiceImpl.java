package com.ipowertec.abigear.service.weixin;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipowertec.abigear.domain.weixin.AccessToken;
import com.ipowertec.abigear.domain.weixin.UserInfo;
import com.ipowertec.abigear.infrastructure.httpclient.WeixinHttpClient;

@Service
public class WeixinOAuth2ServiceImpl implements WeixinOAuth2Service{
    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinOAuth2ServiceImpl.class); 
    private static final String OAUTH2_BASE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    private static final String APPID = "wxee1fb0bc92860096";
    private static final String SECRET = "29933fba24e59cdb89a8ba8802d086ca";
    private static final String REDIRECT_URI = "http://wx.abigear.com/userinfo";
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "snsapi_userinfo";
    private static final String STATE = "1";
    
    @Autowired
    private WeixinHttpClient weixinHttpClient;

    
    @Override
    public String getOAuth2Url(HttpServletRequest request) throws Exception{
        String redirectUri = "";
        try {
            redirectUri = java.net.URLEncoder.encode(REDIRECT_URI, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("getOAuth2Url failed.", e);
        }
        
        String oauth2Url = OAUTH2_BASE_URL 
                + "appid=" + APPID 
                + "&redirect_uri=" + redirectUri 
                + "&response_type=" + RESPONSE_TYPE 
                + "&scope=" + SCOPE 
                + "&state=" + STATE 
                + "#wechat_redirect";
        
        return "redirect:" + oauth2Url;
    }
    
    @Override
    public AccessToken getAccessToken(String code) throws Exception{
        String accessTokenUrl = 
                "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID 
                + "&secret=" + SECRET + "&code=" + code + "&grant_type=authorization_code";
        String accessToken = weixinHttpClient.sendHttpPost(accessTokenUrl);
        
        return null;
    }
    
    @Override
    public UserInfo getUserInfo(AccessToken accessToken) throws Exception {
        String baseUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=";
        String token = accessToken.getToken();
        String openId = accessToken.getOpenid();
        String userInfoUrl = baseUrl + token + "&openid=" + openId;            
        String userInfo = weixinHttpClient.sendHttpPost(userInfoUrl);
        return null;
    }
    



}
