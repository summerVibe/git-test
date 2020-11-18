package my.时间日期;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author  : J
 * @version : Aug 16, 2017  10:44:19 AM
 * explain  :  
 */
public class Test {
	
//	@org.junit.Test
	public void test_SimpleDateFormat_(){
		
		Date d = new Date(1504576622);
		SimpleDateFormat_ s = new SimpleDateFormat_();
//		s.formatDate(new Date());
		System.out.println(s.formatDate(d));
	}
	
//	@org.junit.Test
	public void currentTimeMillis(){
		System.out.println(System.currentTimeMillis());
	}

//	@org.junit.Test
	public  void getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String date = sdf.format(new Date());
		System.out.println(date);
	}
	
//	@org.junit.Test
	public  void getDate2() throws ParseException {
		String s ="2008-07-10 19:20:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(s);
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		String ss = sdf2.format(date);
		System.out.println(ss);
	}
	
//	@org.junit.Test
	public void compare_date2() {
		String DATE = "2017-10-10 17:10:09";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			Date dt1 = df.parse(DATE);
			if (dt1.getTime() > date.getTime()) {
				System.out.println("晚与当前时间");
			} else if (dt1.getTime() < date.getTime()) {
				System.out.println("早与当前时间");
			} else {
				System.out.println("相等");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
//	@org.junit.Test
	public void date1(){
		String da = "2017-10-19 33:88:88";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = dateFormat.parse(da);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
			System.out.println(" yyyy-MM-dd  "+dateFormat1.format(d));
			System.out.println(" HH:mm:ss  "+dateFormat2.format(d));
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
//	@org.junit.Test
	public void date2() throws ParseException{
		// 字符串转时间
		String da = "2018-3-03";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 =  sdf.parse(da);
		System.out.println("d1    "+d1);
		Date d = new Date();
		String da2 = sdf.format(d);
		System.out.println("da2    "+da2);
		Date d2 =  sdf.parse(da2);
		// 预约  - 现在
		long date = d1.getTime() - d2.getTime();
		if(date/(1000 * 60 * 60 * 24) > 0){
			System.out.println("相差至少一天");
		}else{
			System.out.println("相差没有一天");
		}
		
	}
	
//	@org.junit.Test
	public void date3() throws ParseException{
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如2016-08-10 20:40  
		String fromDate = simpleFormat.format("2016-05-01 12:00");  
		String toDate = simpleFormat.format("2016-06-01 12:00");  
		long from = simpleFormat.parse(fromDate).getTime();  
		long to = simpleFormat.parse(toDate).getTime();  
		int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
	}
	
	
	
	
//	@org.junit.Test
	public void year() throws ParseException{
		 Calendar date = Calendar.getInstance();
	     String year = String.valueOf(date.get(Calendar.YEAR));
	     int y = Integer.parseInt(year);
	     int in = y - 2018;
	     for(int i = 0;i<in ;i++){
	    	 
	     }
	     System.out.print(year);
	}
	
//	@org.junit.Test
	public void test1(){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String date = simpleFormat.format(new Date());
		System.out.println("now date "+date);
	}


//	@org.junit.Test
	public void test2(){
		String str = "2018-09-16 19:35:09";
		String regEx1 = "^[1-9][0-9]{3}-((01|03|05|07|08|10|12)-(0[1-9]|[1-2][0-9]|30|31)|(04|06|09|11)-(0[1-9]|[1-2][0-9]|30)|(02)-(0[1-9]|1[0-9]|2[0-9])) ([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		String regEx2 = "^[1-9][0-9]{3}-((01|03|05|07|08|10|12)-(0[1-9]|[1-2][0-9]|30|31)|(04|06|09|11)-(0[1-9]|[1-2][0-9]|30)|(02)-(0[1-9]|1[0-9]|2[0-9])) ([01][0-9]|2[0-3]):([0-5][0-9])$";
		SimpleDateFormat sdf = null;

		Pattern pattern1 = Pattern.compile(regEx1);
		Matcher matcher1 = pattern1.matcher(str);
		boolean rs1 = matcher1.matches();

		Pattern pattern2 = Pattern.compile(regEx2);
		Matcher matcher2 = pattern2.matcher(str);
		boolean rs2 = matcher2.matches();

		if (rs1) {

			System.out.print("1----"+str);

		}

		if (rs2) System.out.print("2----"+str+":00");

	}

//	@org.junit.Test
	public void test3(){
		String str = "2018-09-16 19:35";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date utilDate = null;
		try {
			utilDate = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(utilDate);//查看utilDate的值

	}

//	@org.junit.Test
	public void test4(){
		String str = "2018-09-16 19:35:20";
		String str2 = "2018-09-16 19:37:11";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = sdf.parse(str);
			d2 = sdf.parse(str2);
			long i = (d2.getTime() - d1.getTime()) - 1000 * 60 * 2;
			System.out.println("-------------------i"+i);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(d1);//查看utilDate的值
	}

//	@org.junit.Test
	public void test5() throws Exception{

		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = "2019-03-30 21:59:06";
		d = sf.parse(string);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.setTime(d);
		gc.add(2, 1);//2代表月份，1代表在当前的日期添加一个月
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		System.out.println(sf.format(gc.getTime()));



		Calendar calendar = Calendar.getInstance();//得到Calendar实例
		calendar.setTime(d);
		System.out.println(">>>>>>  本月最后一天 ："+calendar.getActualMaximum(Calendar.MONTH));
		calendar.add(Calendar.MONTH, 1);
		Date starDate = calendar.getTime();//得到时间赋给Data
		String stardtr = sf.format(starDate);//使用格式化Data
		System.out.println(">>>>>>>>>>>>>>>>>>    "+stardtr);

	}
//	@org.junit.Test
	public void test6() throws Exception{
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2 = new SimpleDateFormat("dd");
		String string = "2019-02-12 21:59:06";
		d = sf.parse(string);
		String day = sf2.format(d);
		System.out.println(">>>>>>>day  "+day);
		Calendar calendar=Calendar.getInstance();
		calendar.clear();
		calendar.setTime(d);
		/*calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 1);*/
		int firstDay=calendar.getActualMinimum(calendar.DAY_OF_MONTH);
		int lastDay=calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		System.out.println(2+"月第一天是："+firstDay);
		System.out.println(2+"月最后一天是："+lastDay);
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(calendar.getTime()));
	}


//	@org.junit.Test
	public void test7() throws Exception{
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2 = new SimpleDateFormat("dd");
		String string = "2019-02-28 21:59:06";
		date = sf.parse(string);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设定当前时间为每月一号
		System.out.println("-----------------"+sf.format(calendar.getTime()));
		// 当前日历的天数上-1变成最大值 , 此方法不会改变指定字段之外的字段
		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		System.out.println("-----------------"+sf.format(calendar.getTime()));
	}

	@org.junit.Test
	public void test8() throws Exception{
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2 = new SimpleDateFormat("dd");
		String tillDate = "2019-02-28 21:59:06";
		List<String> renewDates = new ArrayList<>();
		try {
			Date date = sf1.parse(tillDate);
			Integer day = Integer.valueOf(sf2.format(date));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int lastDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);// 获取当月最后一天
			for (int i = 1;i <= 50;i++){
				calendar.clear();
				// 1.判断到期时间是否为最后一天
				// 1.1如果为最后一天，那么加n月，都为n月后的最后一天
				if (day == lastDay){
					calendar.setTime(date);
					calendar.add(Calendar.MONTH, i);
					calendar.set(Calendar.DAY_OF_MONTH, 1);// 设定当前时间为每月一号
					// 当前日历的天数上-1变成最大值 , 此方法不会改变指定字段之外的字段
					calendar.roll(Calendar.DAY_OF_MONTH, -1);
				}
				// 1.2如果不是最后一天,直接加月份
				else{
					calendar.add(Calendar.MONTH, i);
				}
				Date starDate = calendar.getTime();//得到时间赋给Data
				String stardtr = sf1.format(starDate);//使用格式化Data
				renewDates.add(stardtr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("renewDates      "+JSONArray.toJSONString(renewDates));
	}


}
