package my.RedisJava;
/** 
 * @author  J
 * @date 创建时间：Jan 16, 2018 - 11:16:15 AM
 * @version 1.0 
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
    
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}

    


