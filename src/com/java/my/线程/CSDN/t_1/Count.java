package my.线程.CSDN.t_1;
/**
 * @author  : J
 * @version : Jul 24, 2017  9:38:17 AM
 * explain  : http://blog.csdn.net/ghsau/article/details/7421217
 */
public class Count {
	
	private int num;
	public void count(){
//		int num = 0;
		for(int i = 1;i <= 10;i++){
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "----" + num);
	}
}
