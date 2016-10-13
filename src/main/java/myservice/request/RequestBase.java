package myservice.request;

import java.util.HashMap;
import java.util.Map;

public abstract class RequestBase implements Request {
	
	private String url;
	
	private String methodType;
	
	private Map<String, String> headers = new HashMap<String, String>();
	
	private String httpType;

	/**
	 * @return the httpType
	 */
	public String getHttpType() {
		return httpType;
	}

	/**
	 * @param httpType the httpType to set
	 */
	public void setHttpType(String httpType) {
		this.httpType = httpType;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * @return the heads
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param heads the heads to set
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the methodType
	 */
	public abstract String getMethodType();
	
}
