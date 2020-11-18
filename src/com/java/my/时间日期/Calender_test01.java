package my.时间日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender_test01 {

//	@org.junit.Test
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("calendar     ");
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date d = calendar.getTime();
		System.out.println("    d      ----"+ sdf.format(d));
		
		calendar.clone();
		
		String s = sdf.format(calendar.getTimeInMillis());
		System.out.println(s);
		String s2 = sdf.format(d);
		System.out.println("    s2     "+  s2);
		
		Date date = new Date();
		System.out.println("date————————"+ date);
		String s1 = sdf.format(date);
		System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth()+1);
		System.out.println(s1);
	}

	@org.junit.Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date d1 = calendar.getTime();
		String s1 = sdf.format(d1);
		System.out.println("calendar1     "+calendar.toString());
		System.out.println("s1     "+s1);
		calendar.add(Calendar.DAY_OF_MONTH, 15);
		Date d2 = calendar.getTime();
		String s2 = sdf.format(d2);
		System.out.println("calendar2     "+calendar.toString());
		System.out.println("s2     "+s2);
		long i = (d2.getTime() - d1.getTime()) - 1000 * 60 * 60 * 24 * 14 ;
		if (i > 0){
			System.out.println(">>>>>>>>>>>>  大于"+i);
		}
		System.out.println(">>>>>>>>>>>>  "+i);
	}


//	@org.junit.Test
	public void test3() {
		String dateStr1 = "2019-01-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = sdf.parse(dateStr1);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			calendar.add(Calendar.DAY_OF_MONTH, 15);
			Date date2 = calendar.getTime();
			long i = (date2.getTime() - date1.getTime()) - 1000 * 60 * 60 * 24 * 14 ;
			if (i > 0){
				System.out.println(">>>>>>>>>>>>  大于"+i);
			}
			System.out.println(">>>>>>>>>>>>  "+i);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
