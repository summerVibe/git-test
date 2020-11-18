package my.regex_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/** 
 * @author  J
 * @date 创建时间：Dec 22, 2017 - 2:37:11 PM
 * @version 1.0 
 */
public class Test1 {
	
	@Test
	public void test1(){
		String tel = "(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?";
		String tel2 = "1[34578]\\d{9}";
		String cz = "(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?";
		
		
		String t1 = "028-11111111";
		// 编译正则表达式
	    Pattern pattern = Pattern.compile(cz);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(t1);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    System.out.println(rs);
		
	}

}
