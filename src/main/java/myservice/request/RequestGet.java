package myservice.request;

public class RequestGet extends RequestBase implements Request{

	@Override
	public String getMethodType() {
		return Request.GET;
	}
	
}
