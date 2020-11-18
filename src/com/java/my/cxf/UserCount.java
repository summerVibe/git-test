package my.cxf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.gxkj.emailws.service.impl.EmailCountWs;
import com.gxkj.emailws.service.impl.EmailCountWsImplService;
import com.gxkj.emailws.service.impl.Exception;
import com.gxkj.emailws.service.impl.UserCountWs;
import com.gxkj.emailws.service.impl.UserCountWsImplService;

/** 
 * @author  J
 * @date 创建时间：Dec 2, 2017 - 11:33:32 AM
 * @version 1.0 
 */
public class UserCount {
	
	public static void main(String[] args) throws Exception {
		UserCountWsImplService ws = new UserCountWsImplService();
		UserCountWs userCountWsImplPort = ws.getUserCountWsImplPort();
//		String rcUserCount = userCountWsImplPort.rcUserCount("2017");
//		System.out.println(rcUserCount);
		
//		String zwUserCount = userCountWsImplPort.zwUserCount("2017");
//		System.out.println(zwUserCount);
		
//		String rcUserCount = userCountWsImplPort.userLoginCount("2", "day");
//		System.out.println(rcUserCount);
		
		EmailCountWsImplService e = new EmailCountWsImplService();
		EmailCountWs emailCountWsImplPort = e.getEmailCountWsImplPort();
		String s = emailCountWsImplPort.emailCount("17");
		System.out.println(s);
		
	}
	
//	@Test
	public void test2(){
		try {
			Date parse = new SimpleDateFormat("yyyy").parse("12");
			System.out.println("ok");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("err");
		}
	}
	
//	@Test
	public void test3(){
		String y = "20eq";
		if(y.matches("^[1-9][0-9]{3}$")){
			System.out.println("ok");
		}else{
			System.out.println("err");
		}
	}

}
