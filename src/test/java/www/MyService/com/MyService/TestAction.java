package www.MyService.com.MyService;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

/** 
 * @author  313353-qiupeng
 * @date 创建时间：2016-10-12 下午2:20:00 
 * @version 1.0 
 **/
public class TestAction {
	/**
	 * 模拟客户端
	 */
	public void virtualClient(){
		HttpClientParams params = new HttpClientParams();
		params.setContentCharset("UTF-8");
		HttpClient client = new HttpClient(params);
		
//		HttpMethod method = HttpMethod.valueOf("http://localhost:8080");
		GetMethod method = new GetMethod("http://localhost:9090/ok?");
		method.addRequestHeader("aaa", 
				new String("能不能行啊".getBytes(),Charset.forName("UTF-8")));
		try {
			client.executeMethod(method);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		TestAction testAction = new TestAction();
		testAction.virtualClient();
	}
}
