package my.线程;
/**
 * @author  : J
 * @version : May 11, 2017  11:30:26 AM
 * explain  : 消费者类Consumer继承线程类Thread 
 */
public class Consumer extends Thread{
	
	//每次消费数量
	private int num;
	//所在放置的仓库
	private Storage storage;
	
	public Consumer(Storage storage){
		this.storage = storage;  
	}
	
	 // 线程run函数  
    public void run()  
    {  
        consume(num);  
    }  
  
    // 调用仓库Storage的生产函数  
    public void consume(int num)  
    {  
        storage.consume(num);  
    }  
  
    // get/set方法  
    public int getNum()  
    {  
        return num;  
    }  
  
    public void setNum(int num)  
    {  
        this.num = num;  
    }  
  
    public Storage getStorage()  
    {  
        return storage;  
    }  
  
    public void setStorage(Storage storage)  
    {  
        this.storage = storage;  
    }  
}
