package com.ipowertec.abigear.infrastructure.httpclient;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class AlarmHttpClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmHttpClient.class); 
	
	
	public String sendHttpPost(String url, JSONObject json) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String responseBody = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(json.toString(),"UTF-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			    @Override
			    public String handleResponse(
			            final HttpResponse response) throws ClientProtocolException, IOException {
			        int status = response.getStatusLine().getStatusCode();
			        if (status >= 200 && status < 300) {
			            HttpEntity entity = response.getEntity();
			            return entity != null ? EntityUtils.toString(entity) : null;
			        } else {
			        	LOGGER.error("Unexpected response status: " + status);
			            throw new ClientProtocolException("Unexpected response status: " + status);
			        }
			    }

			};
			responseBody = httpClient.execute(httpPost,responseHandler);
		} catch (UnsupportedCharsetException e) {
			LOGGER.error("sendHttpPost failed.", e);
		} catch (ClientProtocolException e) {
			LOGGER.error("sendHttpPost failed.", e);
		} catch (IOException e) {
			LOGGER.error("sendHttpPost failed.", e);
		} finally {
			httpClient.close();
		}
		return responseBody;
	}
}
