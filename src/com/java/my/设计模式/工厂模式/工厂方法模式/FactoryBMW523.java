package my.设计模式.工厂模式.工厂方法模式;
/**
 * @author  : J
 * @version : Jul 3, 2017  5:14:35 PM
 * explain  : 
 */
public class FactoryBMW523 implements FactoryBMW {

	@Override
	public BMW523 createBMW() {
		return new BMW523();
	}

}
