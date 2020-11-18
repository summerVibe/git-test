package my.线程.deadLock;

public class Thread1 extends Thread{
    private DeadLock d1;

    public Thread1(DeadLock d1){
        this.d1 = d1;
    }

    @Override
    public void run() {
        try {
            d1.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
