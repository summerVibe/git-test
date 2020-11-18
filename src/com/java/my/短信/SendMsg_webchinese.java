package my.短信;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @author  : J
 * @version : Jul 7, 2017  3:22:18 PM
 * explain  : http://blog.csdn.net/csh624366188/article/details/7183457
 */
public class SendMsg_webchinese {
	
	public static void main(String[] args) {
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
		// 在头文件中设置转码 
		post.addRequestHeader("Content-Type",  
	                "application/x-www-form-urlencoded;charset=gbk");
		NameValuePair[] data = {
			// 注册的用户名  	
			new NameValuePair("Uid", "jack_4"),
			
			new NameValuePair("Key", "6b8082028015ec74b47b"), // 注册成功后,登录网站使用的密钥  
			// 手机号码  13908009944
			new NameValuePair("smsMob", "13908009944"),
			// 设置短信内容 
            new NameValuePair("smsText", "")
		};  
		
		try {
			post.setRequestBody(data);
			client.executeMethod(post);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Header[] headers = post.getRequestHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("状态 ： "+statusCode);
		
		// -14  短信内容出现非法字符
		for(Header h : headers){
			System.out.println(h.toString());
		}
		
		try {
			String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
			System.out.println("result: "+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		post.releaseConnection();
	}

}
