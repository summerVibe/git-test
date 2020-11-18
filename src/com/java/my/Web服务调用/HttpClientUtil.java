package my.Web服务调用;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author : J
 * @version : Jul 21, 2017 1:46:38 PM explain :
 */
public class HttpClientUtil {

	public static void main(String[] args) {
		HttpClientUtil.getByHttpPost();  
	}
	
	
	
	
	public static String getByHttpPost() {

		// 1.创建HttpClient对象。(创建默认的httpClient实例.)
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 首页
		String indexStr = "http://music-download.dev.fotoable.net/musics/lists";
		// 搜索
		String searchStr = "http://music-download.dev.fotoable.net/public/search";

		// 2.创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。(创建httppost)
		HttpPost httppost = new HttpPost(searchStr);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		// 3.如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams
		// params)方法来添加请求参数；
		// 对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
		// 关键词搜索传参(创建参数队列)
		formparams.add(new BasicNameValuePair("keyword", "See you again"));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0");
			httppost.setHeader("Connection", "keep-alive");
			httppost.setHeader("Accept-Language",
					"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			httppost.setHeader("Accept-Encoding", "gzip, deflate");
			httppost.setHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httppost.setHeader("JSESSIONID", "536020F424630F22DB1F4EAEAD8E83BD");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			// 4.调用HttpClient对象的execute(HttpUriRequest
			// request)发送请求，该方法返回一个HttpResponse。
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out
							.println("--------------------------------------");
					System.out.println("Response content: "
							+ EntityUtils.toString(entity, "UTF-8"));
					System.out
							.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 释放连接。无论执行方法是否成功，都必须释放连接
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
