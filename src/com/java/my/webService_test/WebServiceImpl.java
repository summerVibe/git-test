package my.webService_test;

import javax.jws.WebService;

/**
 * @author  : J
 * @version : May 9, 2017  5:36:38 PM
 * explain  :  SEI的具体实现
 */
// 注意：使用@WebService注解标注WebServiceI接口的实现类WebServiceImpl
@WebService
public class WebServiceImpl implements WebServiceI {

	@Override
	public String sayHello(String name) {
		
		System.out.println("WebService sayHello "+name);
		
		return "sayHello "+name;
	}

}
