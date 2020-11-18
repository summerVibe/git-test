package my.设计模式.代理模式.imooc;
/**
 * @author  : J
 * @version : Aug 15, 2017  11:12:38 AM
 * 通过聚合实现
 */
public class Car3 implements Moveable{
	private Car car;
	
	public Car3(Car car) {
		super();
		this.car = car;
	}


	@Override
	public void move() {
		// 开始时间
		long starttime = System.currentTimeMillis();
		System.out.println("开始行使");
		car.move();
		// 结束时间
		long endtime = System.currentTimeMillis();
		System.out.println("结束行使");
		
	}
	

}
