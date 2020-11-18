package my.string_test;

import java.util.Arrays;

/**
 * @author  : J
 * @version : May 7, 2017  9:23:18 PM
 * explain  : string 方法
 */
public class String_method {

	public static void main(String[] args) {
		float f = 111.00001000f;
		String i = "sa.sd.aa";
		
		String s = f+"";
		
		String[] ss = i.split(".");
		
		System.out.println(Arrays.toString(ss));
		System.out.println(ss.toString());
		
	}

}
