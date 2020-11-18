package my.时间日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh-MM-ss");
//		//当前时间
//		Date d1 = new Date();
//		int i = 10;
//		
//		Calendar ca = Calendar.getInstance();
//		ca.add(Calendar.DATE, i);
//		
//		//   当前时间+10天
//		Date d2 = ca.getTime();
//		String sd2 = s.format(d2);
//		String s2 = s.format(ca.getTime());
//		
//		long l = d1.getTime()-d2.getTime();
//		String s3 = s.format(l);
//		int i1 = (int) (l/60/60/1000/24); 
//		
//		Date d3 = null;
//		
//		System.out.println(" data当前时间： " +s.format(new Date()));
//		System.out.println(" Calendar当前时间：  "+s2);
//		System.out.println("Calendar.DATE   :"+Calendar.DATE);
//		System.out.println("时间差"+i1);
//		System.out.println("当前时间+10天    "+sd2);
		
		
		
		
		DateUtil d = new DateUtil();
		Date dd =  d.formatStrToDateYMD("2017-2-3");
		System.out.println(d.formatStrToDateYMD("2017-2-3"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(new Date());
		Date date = null;
		try {
			date =  sdf.parse(s);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
