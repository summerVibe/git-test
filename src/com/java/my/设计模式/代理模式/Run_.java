package my.设计模式.代理模式;
/**
 * @author  : J
 * @version : Jul 5, 2017  2:26:11 PM
 * explain  : 
 */
public class Run_ {
	public static void main(String[] args) {
		People p1 = new People();
		p1.setCash(60000);
		p1.setUserName("張三");
		
		People p2 =new People();  
		p2.setCash(40000);  
		p2.setUserName("李四");  
       
		People p3 =new People();  
		p3.setCash(0);  
		p3.setUserName("王五");  
		p3.setVip("VIP");  
		
		ProxyClass proxy_buy = new ProxyClass();  
		proxy_buy.setPeople(p1);  
		proxy_buy.buy_myCar();  
       
		proxy_buy.setPeople(p2);  
		proxy_buy.buy_myCar();  
       
		proxy_buy.setPeople(p3);  
		proxy_buy.buy_myCar();  
		
	}

}
