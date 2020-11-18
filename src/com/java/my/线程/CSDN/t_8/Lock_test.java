package my.线程.CSDN.t_8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author  : J
 * @version : Jul 25, 2017  9:21:15 AM
 * explain  : 
 */
public class Lock_test {
	public static void main(String[] args) {
		final Outputter1 out = new Outputter1();
		new Thread(){
			@Override
			public void run() {
				out.output("zhangsan");
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				out.output("lisi");
			}
		}.start();
		
	}
	
}

class Outputter1{
	
	private Lock lock = new ReentrantLock();
	public void output(String name){
		
		lock.lock();// 获得锁
		try {
			for(int i = 0;i < name.length();i++){
				System.out.print(name.charAt(i));
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();// 释放锁  注意：要将释放锁放在finally中；
		}
		
	}
}
