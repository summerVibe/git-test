package my.设计模式.工厂模式.抽象工厂模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  2:44:42 PM
 * explain  : 
 */
public class Customer {

	public static void main(String[] args) {
		// 生产宝马320系列配件 
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();
		factoryBMW320.createEngine();
		factoryBMW320.createaAircondition();
		
		// 生产宝马523系列配件    
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();    
        factoryBMW523.createEngine();  
        factoryBMW523.createaAircondition();  
	}
}
