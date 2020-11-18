package my.设计模式.工厂模式.工厂方法模式;
/**
 * @author  : J
 * @version : Jul 3, 2017  5:06:20 PM
 * explain  : 
 */
public class Customer {
	public static void main(String[] args){
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();  
		BMW320 B_320 = factoryBMW320.createBMW();
		
		FactoryBMW523 factoryBMW523 = new FactoryBMW523();  
		BMW523 B_523 = factoryBMW523.createBMW();
	}
}
