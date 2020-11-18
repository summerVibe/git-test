package my.webService_test;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author  : J
 * @version : May 9, 2017  5:33:41 PM
 * explain  : 
 */

/**
 * 定义SEI(WebService EndPoint Interface(终端))
 * @author thinkpad
 */
@WebService
public interface WebServiceI {
	
	// 使用@WebMethod注解标注WebServiceI接口中的方法
	@WebMethod
	String sayHello(String name);
}
