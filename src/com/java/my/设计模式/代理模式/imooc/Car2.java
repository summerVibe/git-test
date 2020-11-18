package my.设计模式.代理模式.imooc;
/**
 * @author  : J
 * @version : Aug 15, 2017  11:07:17 AM
 * 通过继承实现
 */
public class Car2 extends Car {

	@Override
	public void move() {
		// 开始时间
		long starttime = System.currentTimeMillis();
		System.out.println("开始行使");
		super.move();
		// 结束时间
		long endtime = System.currentTimeMillis();
		System.out.println("结束行使");
	}
	

}
