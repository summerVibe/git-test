package my.线程.deadLock;

public class Thread2 extends Thread{

    private DeadLock d1;

    public Thread2(DeadLock d1){
        this.d1 = d1;
    }

    @Override
    public void run() {
        try {
            d1.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
