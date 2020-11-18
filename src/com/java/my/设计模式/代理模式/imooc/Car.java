package my.设计模式.代理模式.imooc;

import java.util.Random;

/**
 * @author  : J
 * @version : Aug 15, 2017  10:59:26 AM
 * 一般的做法
 */
public class Car implements Moveable{
	
	
	@Override
	public void move() {
		// 开始时间
		long starttime = System.currentTimeMillis();
		System.out.println("开始行使");
		// 实现开车
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("行使中");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 结束时间
		long endtime = System.currentTimeMillis();
		System.out.println("结束行使");
	}
}
