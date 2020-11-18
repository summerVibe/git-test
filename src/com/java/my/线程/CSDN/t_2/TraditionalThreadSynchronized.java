package my.线程.CSDN.t_2;

/**
 * @author : J
 * @version : Jul 24, 2017 10:57:39 AM 
 * explain :  http://blog.csdn.net/ghsau/article/details/7424694
 */
public class TraditionalThreadSynchronized {  
    public static void main(String[] args) {  
        final Outputter output = new Outputter();  
        new Thread() {  
            public void run() {  
                output.output("zhangsan");  
            }  
        }.start();        
        new Thread() {  
            public void run() {  
                output.output("lisi");  
            }  
        }.start();  
    }  
}  
class Outputter {  
	// 
    public synchronized void output(String name) {
    	
//    	Object lock = new Object();
    	
    	// 同步代块
//        synchronized (this) {
			// TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符  
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}  
    }  
} 
