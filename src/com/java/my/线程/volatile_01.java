package my.线程;
/**
 *@author  : J
 *@version : Aper 18, 2017  5:04:35 PM
 * explain : volatile关键字：能保证对变量操作的可见性，不能保证原子性
 * http://blog.csdn.net/victor_cindy1/article/details/44310195
 */
public class volatile_01 {  
    public volatile int inc = 0;  
       
    // 加：synchronized 
    public synchronized void increase() {  
        inc++;  
    }  
       
    public static void main(String[] args) {  
        final volatile_01 test = new volatile_01();  
        for(int i=0;i<10;i++){  
            new Thread(){  
                public void run() {  
                    for(int j=0;j<1000;j++)  
                        test.increase();
                };  
            }.start();  
        }  
           
        while(Thread.activeCount()>1)  //保证前面的线程都执行完  
            Thread.yield();  
        System.out.println(test.inc);  
        
    }  
}  
