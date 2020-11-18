package my.时间日期;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/** 
 * @author  J
 * @date 创建时间：Sep 6, 2017 - 10:34:07 AM
 * @version 1.0 
 */
public class T {
	
	@Test
	public void test(){
		Date date = new Date();
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(date));
	}

}
