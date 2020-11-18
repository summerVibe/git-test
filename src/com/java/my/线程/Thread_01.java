package my.线程;

import java.util.Random;

/**
 * 30张票，5个窗口，用5个线程模拟售票情况；
 * 
 * @author thinkpad
 * 
 */
public class Thread_01 implements Runnable {

	static int num;
	static int count;

	Thread_01() {
		num = 100;
		count = 0;
	}

	@Override
	public void run() {
		while (num > 0) {
			synchronized (this) {
				try {
					Thread.sleep(new Random().nextInt(20));
					if (num == 0) {
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "--票号："
						+ num);
				num--;
				count++;
			}
		}

	}

	public static void main(String[] args) {
		Thread_01 ticket = new Thread_01();
		for (int line = 1; line <= 5; line++) {
			new Thread(ticket, "窗口：" + line).start();
		}
	}

}
