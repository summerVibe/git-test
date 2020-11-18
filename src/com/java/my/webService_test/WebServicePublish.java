package my.webService_test;

import javax.xml.ws.Endpoint;

/**
 * http://www.cnblogs.com/xdp-gacl/p/4259481.html#undefined
 * @author  : J
 * @version : May 9, 2017  5:38:29 PM
 * explain  : 
 */
public class WebServicePublish {

	public static void main(String[] args) {
		
		// 定义WebService的发布地址，这个地址就是提供给外界访问Webervice的URL地址，URL地址格式为：http://ip:端口号/xxxx
		//String address = "http://192.168.1.104:8989/";这个WebService发布地址的写法是合法的
		//String address = "http://192.168.1.104:8989/Webservice";这个WebService发布地址的是合法的
		String  address = "http://localhost:8889/WS_Server/Webservice";
		
		//使用Endpoint类提供的publish方法发布WebService，发布时要保证使用的端口号没有被其他应用程序占用
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("发布成功");
		// 打开网页输入地址即可
	}
}
