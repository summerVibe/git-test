package my.线程;

import java.util.LinkedList;

/**
 * http://blog.csdn.net/monkey_d_meng/article/details/6251879
 * @author : J
 * @version : May 11, 2017 11:13:22 AM 
 * explain : 仓库类Storage实现缓冲区
 */
public class Storage {

	// 仓库最大储量
	private final int MAX_SIZE = 100;

	// 仓库储存载体
	private LinkedList<Object> list = new LinkedList<>();

	// 生成num 个产品
	public void produce(int num) {
		// 同步代码段
		synchronized (list) {
			// 如果仓库剩余容量不足
			while (list.size() + num > MAX_SIZE) {
				System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:"
						+ list.size() + "/t暂时不能执行生产任务!");
			}
			try {
				// 由于条件不满足，生产阻塞
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 生产条件满足情况下，生产num个产品
		for (int i = 1; i <= num; ++i) {
			list.add(new Object());
		}
		System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
		list.notifyAll();
	}

	// 消费num个产品
	public void consume(int num) {
		synchronized (list) {
			while (list.size() < num) {
				System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:"
						+ list.size() + "/t暂时不能执行生产任务!");
				try {
					// 由于条件不满足，消费阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			
			for(int i = 1; i <= num;++i ){
				list.remove();
			}
			 System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());  
			  
	         list.notifyAll();  
		}
	}

	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

}
