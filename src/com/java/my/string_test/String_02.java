package my.string_test;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author  : J
 * @version : 2017年5月28日  下午7:24:32
 * explain  : 
 */
public class String_02 {

	public static void main(String[] args) {

//		String s = "user";
//		int i = s.lastIndexOf("_");
//		System.out.println(i);
//		
//		String name = s.substring(0,i);
//		String value = s.substring(i+1);
//		
//		System.out.println(name);
//		System.out.println(value);
		
		
//		String s1 = ",1,2,3,4,5,";
//		s1 = s1.substring(1);
//		System.out.println(s1);
		
		
		boolean s = sql_inj("exec");
		System.out.println(s);

	}
	/**
	 * 验证字符是否有注入关键字
	 * @param str
	 * @return
	 */
	public static boolean sql_inj(String str) {
		String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String[] inj_stra = inj_str.split("\\|");// 转义符
		System.out.println(Arrays.toString(inj_stra));
		System.out.println(inj_stra[1]);
		
		for (int i = 0; i < inj_stra.length; i++) {
			if (str.indexOf(inj_stra[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

	
//	@Test
	public void test(){
		String s = "123@qq.com";
		String s2 = "og1321311";
		
		boolean a = s2.startsWith("og");// 判断是不是部门id
		boolean b = s2.indexOf("@")== -1;//不包含
		
		
		System.out.println(a +"  "+ b);
		
	}
	
	@Test
	public void test2(){
		String s1 = "15608099852";
		
		String s2 = s1.substring(3, 9);
		String s3 = s1.replace(s2, "******");
		
		System.out.println(s3);
		
	}
	
	
	
}
