package my.设计模式.代理模式.imooc;
/**
 * @author  : J
 * @version : Aug 15, 2017  11:21:23 AM
 * http://www.imooc.com/video/4682
 */
public class CarTimeProxy implements Moveable{
	private Moveable m;
	
	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		// 开始时间
		long starttime = System.currentTimeMillis();
		System.out.println("开始行使");
		m.move();
		// 结束时间
		long endtime = System.currentTimeMillis();
		System.out.println("结束行使");
		
	}
	
}
