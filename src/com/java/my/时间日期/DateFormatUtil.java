package my.时间日期;

import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	private static final String[] WEEKS = { "日", "一", "二", "三", "四", "五", "六" };

	public static String getChineseTime(Date d) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(1);
		int mouth = c.get(2);
		int day = c.get(5);
		int week = c.get(7);
		
		System.out.print(year + "年" + (mouth + 1) + "月" + day + "日" + " 星期"
				+ WEEKS[(week - 1)]);
		
		return year + "年" + (mouth + 1) + "月" + day + "日" + " 星期"
				+ WEEKS[(week - 1)];
	}

	public static void main(String[] args) {
		DateFormatUtil d = new DateFormatUtil();
		Date date = new Date();
		d.getChineseTime(date);
	}
}
