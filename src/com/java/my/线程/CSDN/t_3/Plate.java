package my.线程.CSDN.t_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者
 * @author  : J
 * @version : Jul 24, 2017  3:09:45 PM
 * explain  : http://blog.csdn.net/ghsau/article/details/7433673
 */
public class Plate {  
    /** 装鸡蛋的盘子 */  
    List<Object> eggs = new ArrayList<Object>();  
    /** 取鸡蛋 */  
    public synchronized Object getEgg() {  
    	/**
    	 * 在调用wait方法时，都是用while判断条件的，而不是if，在wait方法说明中，也推荐使用while，
    	 * 因为在某些特定的情况下，线程有可能被假唤醒，使用while会循环检测更稳妥。
    	 */
        while (eggs.size() == 0) {  
            try {  
            	/**
            	 * wait和notify方法必须工作于synchronized内部，且这两个方法只能由锁对象来调用。
            	 */
                wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        Object egg = eggs.get(0);  
        eggs.clear();// 清空盘子  
        notify();// 唤醒阻塞队列的某线程到就绪队列  ,可能会造成死锁；notifyAll()--释放所有等待线程
        System.out.println("拿到鸡蛋");  
        return egg;  
    }  
    /** 放鸡蛋 */  
    public synchronized void putEgg(Object egg) {  
        while (eggs.size() > 0) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        eggs.add(egg);// 往盘子里放鸡蛋  
        notify();// 唤醒阻塞队列的某线程到就绪队列  
        System.out.println("放入鸡蛋");  
    }  
    static class AddThread implements Runnable  {  
        private Plate plate;  
        private Object egg = new Object();  
        public AddThread(Plate plate) {  
            this.plate = plate;  
        }  
        public void run() {  
            plate.putEgg(egg);  
        }  
    }  
    static class GetThread implements Runnable  {  
        private Plate plate;  
        public GetThread(Plate plate) {  
            this.plate = plate;  
        }  
        public void run() {  
            plate.getEgg();  
        }  
    }  
    public static void main(String args[]) {  
        Plate plate = new Plate();  
        for(int i = 0; i < 10; i++) {  
            new Thread(new AddThread(plate)).start();  
            new Thread(new GetThread(plate)).start();  
        }  
    }  
}  