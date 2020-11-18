package my.线程;
/**
 * @author  : J
 * @version : May 11, 2017  11:25:50 AM
 * explain  :  生产者类Producer继承线程类Thread 
 */
public class Producer extends Thread{
	
	// 每次生产的数量
	private int num;
	// 所在放置的仓库  
	private Storage storage;
	// 构造函数，设置仓库  
	public Producer(Storage storage){
		this.storage = storage;
	}
	
	// 线程run函数  
	public void run(){
		produce(num);  
	}
	// 调用仓库Storage的生产函数  
	public void produce(int num){
		storage.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
}
