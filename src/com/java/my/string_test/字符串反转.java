package my.string_test;
/**
 * @author  : J
 * @version : 2017年6月28日  下午2:05:35
 * explain  : 递归
 */
public class 字符串反转 {

	public static void main(String[] args) {

		System.out.println(reverse("12345"));
		
	}
	
	public static String reverse(String s){
		
		if(s == null || s.length() <= 1){
			return s;
		}
//		System.out.println("  string: "+s);
//		System.out.println("  cher: "+s.charAt(0));
		return reverse(s.substring(1))+s.charAt(0);
	}

}
