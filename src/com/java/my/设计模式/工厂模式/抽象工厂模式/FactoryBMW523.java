package my.设计模式.工厂模式.抽象工厂模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  2:43:45 PM
 * explain  : //宝马523系列 
 */
public class FactoryBMW523 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public Aircondition createaAircondition() {
		return new AirconditionB();
	}

}
