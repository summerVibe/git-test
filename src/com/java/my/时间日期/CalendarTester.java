package my.时间日期;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author J
 * @date 创建时间：Dec 1, 2017 - 10:41:35 AM
 * @version 1.0
 */
public class CalendarTester {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");

	public static void main(String[] args) {
		String source = "2008年2月";
		try {
			Date date = format.parse(source);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			System.out
					.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
