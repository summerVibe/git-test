package my.string_test;

import java.io.UnsupportedEncodingException;

/**
 * @author  : J
 * @version : 2017年6月28日  下午2:18:00
 * explain  : 
 */
public class 字符串编码转换 {

	public static void main(String[] args) {

		String s1 = "你好";
		try {
			// ISO-8859-1
			// UTF-8
			// GB2312
			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
//			System.out.println(s2);
			
			System.out.println(java.nio.charset.Charset.forName("GB2312").newEncoder().canEncode("汉字")); 

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
