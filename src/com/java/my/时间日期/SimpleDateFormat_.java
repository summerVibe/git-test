package my.时间日期;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  : J
 * @version : Aug 16, 2017  10:19:42 AM
 * 	关于 SimpleDateFormat 的非线程安全问题及其解决方案
 * explain  : http://blog.csdn.net/zjf280441589/article/details/50447533
 */
public class SimpleDateFormat_ {
	
	// 第一种解决方式： 使用 ThreadLocal
	private final static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue(){
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	public String formatDate(Date input){
		if(input == null){
			return null;
		}
		return t1.get().format(input);
	}
	
	
	// 第二种解决方式：使用局部变量
	private static final String SIMPLE_FORMAT = "dd/MM/yyyy";
	  
	public String formatDate2(Date input) {
	
		if(input == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_FORMAT);//local variable
		return sdf.format(input);
	}
	
	// 第三种解决方式：同步代码块 synchronized(code)
	
	
	// 第四种解决方式：使用第三方的日期处理函数：
	// 比如 JODA 来避免这些问题，你也可以使用 commons-lang 包中的 FastDateFormat 工具类。

}
