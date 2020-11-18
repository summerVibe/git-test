package my.线程.deadLock;

public class Test {
    public static void main(String[] args) {

        System.out.println("thread start");
        DeadLock d1 = new DeadLock();
        Thread1 t1 = new Thread1(d1);
        Thread2 t2 = new Thread2(d1);
        t1.start();
        t2.start();
        System.out.println("thread end");
        while (true);
    }
}
