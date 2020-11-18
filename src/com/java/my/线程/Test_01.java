package my.线程;

/**
 * 
 * @author thinkpad
 *
 */
public class Test_01 extends Thread implements Runnable {
	public void run(){
		System.err.println("哈哈----哈哈");
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new Test_01());
		thread.start();
	}





}
