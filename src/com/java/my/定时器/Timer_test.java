package my.定时器;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * 2016-11-17
 * @author thinkpad
 *
 */
public class Timer_test extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("haha");
	}
	public static void main(String[] args) {
		Timer timer = new Timer();
		//(TimerTask,long1,long2) 从现在起long1毫秒后，每隔long2毫秒执行一次
		//timer.schedule(new Timer_test(), 1000, 2000);
		
		//(TimerTask,long) 从现在起，long毫秒后执行一次
		//timer.schedule(new Timer_test(), 1000);
		
		//(TimerTask,Date) 在指定时间Date执行一次。
		//(TimerTask,Date,long) 从Date时刻开始，每隔long毫秒执行一次。  
		timer.schedule(new Timer_test(), new Date(),1000);
		
	}
	
}
