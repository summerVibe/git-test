package my.Web服务调用.短信Webservices;
/** 
 * @author  J
 * @date 创建时间：Oct 9, 2017 - 2:36:06 PM
 * @version 1.0 
 */
public class XML_Utils {
	
	/**
	 * 单条短信下发
	 * @param uid
	 * @param upass
	 * @param messid
	 * @param pid
	 * @param phone
	 * @param message
	 * @return
	 */
	public static String sendMessagetoXml(String  uid,String upass,String messid,int pid,String phone,String message){
		StringBuffer returnMessage = new StringBuffer();
		returnMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		returnMessage.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		returnMessage.append("<soap:Body>");
		returnMessage.append("<sendMessage xmlns=\"http://tempuri.org/\">");
		
		returnMessage.append("<uid>"+uid+"</uid>");
		returnMessage.append("<upass>"+upass+"</upass>");
		returnMessage.append("<messid>"+messid+"</messid>");
		returnMessage.append("<pid>"+pid+"</pid>");
		returnMessage.append("<phone>"+phone+"</phone>");
		returnMessage.append("<message>"+message+"</message>");
		returnMessage.append("</sendMessage>");
		returnMessage.append("</soap:Body>");
		returnMessage.append("</soap:Envelope>");
//		System.out.println(returnMessage.toString());
		return returnMessage.toString();
	}
	
	/**
	 * 多条短信群发
	 * @param uid
	 * @param upass
	 * @param pid
	 * @param s
	 * @return
	 */
	public static String sendMessagetoXml2(String  uid,String upass,int pid,String[] s){
		StringBuffer returnMessage = new StringBuffer();
		returnMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		returnMessage.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		returnMessage.append("<soap:Body>");
		returnMessage.append("<mutilSendMessage xmlns=\"http://tempuri.org/\">");
		
		returnMessage.append("<uid>"+uid+"</uid>");
		returnMessage.append("<upass>"+upass+"</upass>");
		returnMessage.append("<pid>"+pid+"</pid>");
		returnMessage.append("<messageFile>");
		for(int i =0;i<s.length;i++){
			returnMessage.append("<string>"+s[i]+"</string>");
		}
		returnMessage.append("</messageFile>");
		returnMessage.append("</mutilSendMessage>");
		returnMessage.append("</soap:Body>");
		returnMessage.append("</soap:Envelope>");
//		System.out.println(returnMessage.toString());
		return returnMessage.toString();
	}
	
}
