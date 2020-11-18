package my.线程.CSDN.t_4;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : J
 * @version : Jul 24, 2017 4:54:23 PM 
 * explain : http://blog.csdn.net/tiancizhenai/article/details/7050302
 */
public class TimerTest {

	static class MyTimerTask1 extends TimerTask {
		public void run() {
			System.out.println("爆炸！！！");
			// 在延时2000毫秒后执行task。不重复执行
			new Timer().schedule(new MyTimerTask2(), 2000);
			System.out.println("----1");
		}
	}

	static class MyTimerTask2 extends TimerTask {
		public void run() {
			System.out.println("爆炸！！！");
			new Timer().schedule(new MyTimerTask1(), 3000);
			System.out.println("----2");
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		System.out.println("----main1");
		timer.schedule(new MyTimerTask2(), 2000);
		System.out.println("----main2");
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
