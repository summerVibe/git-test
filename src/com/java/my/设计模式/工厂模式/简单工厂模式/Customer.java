package my.设计模式.工厂模式.简单工厂模式;
/**
 * @author  : J
 * @version : Jul 3, 2017  5:06:20 PM
 * explain  : 
 */
public class Customer {
	public static void main(String[] args){
		Factory factory = new Factory();  
        BMW bmw320 = factory.createBMW(320);  
        BMW bmw523 = factory.createBMW(523);  
	}
}
