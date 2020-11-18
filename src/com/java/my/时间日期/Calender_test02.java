package my.时间日期;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender_test02 {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		Date date = calendar.getTime();
		System.out.println(s.format(date));
	}*/
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
		ca.setTime(new Date()); //设置时间为当前时间
//		ca.add(Calendar.YEAR, -1); //年份减1
		ca.add(Calendar.MONTH,0);
		Date lastMonth = ca.getTime(); //结果
		String month = month(lastMonth);
		System.out.println("----getQueryCycleMonth   month:"+month);
	}

	public static String month(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String d = format.format(date);
		return d;
	}






}
