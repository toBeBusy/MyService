package myservice.Util;

import java.util.HashMap;
import java.util.Map;

import myservice.request.RequestBase;

import org.apache.commons.lang3.StringUtils;

public class HttpUtil {
	
	public static Map<String, String> getHeaders(String[] message){
		Map<String, String> headers = new HashMap<String, String>();
		for(String head : message){
			String[] temp = head.split(":");
			if(temp.length < 2){
				continue;
			}
			String key = temp[0].trim();
			String value = StringUtils.isEmpty(temp[1]) ? StringUtils.EMPTY : temp[1].trim();
			headers.put(key, value);
		}
		return headers;
	}
	
	public static RequestBase getRequestMessge(RequestBase request, String[] message){
		String[] temp = message[0].split(" ");
		request.setUrl(temp[1]);
		request.setHttpType(temp[2]);
		return request;
	}
}
