package my.设计模式.工厂模式.抽象工厂模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  2:41:33 PM
 * explain  : 为宝马320系列生产配件
 */
public class FactoryBMW320 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		return new EngineA();
	}

	@Override
	public Aircondition createaAircondition() {
		return new AirconditionA();
	}

}
