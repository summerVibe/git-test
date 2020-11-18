package my.线程.CSDN.t_1;
/**
 * @author  : J
 * @version : Jul 24, 2017  9:41:23 AM
 * explain  : http://blog.csdn.net/ghsau/article/details/7421217
 */
public class ThreadTest {

	/**
	 * 上述测试，我们发现，存在成员变量的类用于多线程时是不安全的，不安全体现在这个成员变量可能发生非原子性的操作，
	 * 而变量定义在方法内也就是局部变量是线程安全的。想想在使用struts1时，不推荐创建成员变量，因为action是单例的，
	 * 如果创建了成员变量，就会存在线程不安全的隐患，而struts2是每一次请求都会创建一个action，就不用考虑线程安全的问题。
	 * 所以，日常开发中，通常需要考虑成员变量或者说全局变量在多线程环境下，是否会引发一些问题。
	 *
	 */
	
	
	public static void main(String[] args) {

		Runnable a = new Runnable() {
			Count count = new Count();
			@Override
			public void run() {
//				Count count = new Count();
				count.count();
			}
		};
		for(int i = 1;i <= 10;i++){
			new Thread(a).start();
		}
	}

}
