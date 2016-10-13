package myservice.request;

public interface Request {
	
	public static String GET = "GET";
	
	public static String POST = "POST";
	
	public static String Content_Length = "Content-Length";
	
	public static String Cookie = "Cookie";
	
	public static String From = "From";
	
	public static String Host = "Host";
	
	public static String If_Modified_Since = "If-Modified-Since";
	
	public static String Pragma = "Pragma";
	
	public static String Referer = "Referer";
	
	public static String User_Agent = "User-Agent";
	
	/**
	 * @return the url
	 */
	public String getUrl();

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url);
}
