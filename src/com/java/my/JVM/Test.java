package my.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  : J
 * @version : Aug 17, 2017  3:51:04 PM
 * explain  : http://blog.csdn.net/sunhuaqiang1/article/details/61914317
 * jdk安装目录 下   bin/jconsole.exe
 */
public class Test {
	
//	private static List<Test> list = new ArrayList<>();
//	public static void main(String[] args) {
//		for(int i = 0; i< 10000;i++){
//			Test test = new Test();
//			list.add(test);
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					
				}
			};
		}).start();
	}

}
