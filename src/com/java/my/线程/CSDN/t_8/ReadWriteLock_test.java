package my.线程.CSDN.t_8;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : J
 * @version : Jul 25, 2017 10:18:09 AM 
 * explain : http://blog.csdn.net/ghsau/article/details/7461369
 */
public class ReadWriteLock_test {

	// 读写锁  	在对数据进行读写的时候，为了保证数据的一致性和完整性，需要读和写是互斥的，写和写是互斥的，但是读和读是不需要互斥的，这样读和读不互斥性能更高些，
	public static void main(String[] args) {
		final Data data = new Data();

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.set(new Random().nextInt(30)); // 取 0 ~ 30的随机整数；
					}
				}
			}).start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.get();
					}
				}
			}).start();

		}

	}
}

class Data {
	
	private int data;// 共享数据
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public void set(int data) {
		
		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "准备写入数据");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/**
			 * (1)this调用本类中的属性，也就是类中的成员变量；
			 * (2)this调用本类中的其他方法；
			 * (3)this调用本类中的其他构造方法，调用时要放在构造方法的首行。
			 */
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "写入" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
		
	}

	public void get() {
		
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "准备读取数据");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "读取" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
		
	}
}