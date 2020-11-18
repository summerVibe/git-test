package my.设计模式.工厂模式.抽象工厂模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  2:39:27 PM
 * explain  : 创建工厂的接口
 */
public interface AbstractFactory {
	// 制造发动机
	public Engine createEngine();
	// 制造空调
	public Aircondition createaAircondition();
}
