package my.时间日期;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/** 
 * @author  J
 * @date 创建时间：Oct 10, 2017 - 10:23:44 AM
 * @version 1.0 
 */
public class 时分秒 {
	
//	@Test
	public void h(){
		String time = "08:59";
		if (time .matches("(0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})")) {
			System.out.println("ok");
		}else{
			System.out.println("no");
		}
	}
//	@Test
	public void bb(){
		String receive_start_time = "00:23";
		String receive_end_time = "01:22";
		
		String regEx = "(0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})";
	    Pattern pattern = Pattern.compile(regEx);
	    Matcher matcher1 = pattern.matcher(receive_start_time);
	    Matcher matcher2 = pattern.matcher(receive_end_time);
		
		if ( !matcher1.matches()) {
			System.out.println("起始时间格式不对");
		}else if(!matcher2.matches()){
			System.out.println("结束时间格式不对");
		}else{
			String[] s1 = receive_start_time.split(":");
			String[] s2 = receive_end_time.split(":");
			try {
			    int i1 = Integer.valueOf(s1[0]).intValue();
			    int i2 = Integer.valueOf(s1[1]).intValue();
			    int i3 = Integer.valueOf(s2[0]).intValue();
			    int i4 = Integer.valueOf(s2[1]).intValue();
			    
			    if(i1 > i3){
			    	System.out.println("结束时间（小时）不能比开始时间早");
			    }else if(i1 == i3 && i2 > i4){
			    	System.out.println("结束时间（分钟）不能比开始时间早");
			    }else if(i1 == i3 && i2 == i4){
			    	System.out.println("时间相同");
			    }else{
			    	System.out.println("ok");
			    }
			    
			    
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
	
	}
	
	@Test
	public void test1(){
//		String d1 ="2017-05-23 11:22:37";
//		String d2 ="2017-05-23 11:22:34";
		String d1 ="11:22:37";
		String d2 ="11:22:34";
//		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		d1 = d1.substring(0, 5);
		System.out.println(d1);
		
	}
	

}
