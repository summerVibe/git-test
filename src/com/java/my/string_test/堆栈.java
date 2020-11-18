package my.string_test;

/**
 * 
 * @author J
 * explain:
 */
public class 堆栈 {

	public static void main(String[] args) {
		
		String s1 = new String("abc");
		String s2 = new String("abc");
//		System.out.println(s1 == s2);//false
		
		String str1="abc";
		String str2="abc";
//		System.out.println(str1==str2);//true
		
		String st1 = "abc"; 
		String st2 = new String("abc"); 
//		System.out.println(st1==st2); //false 
		
		// 当比较包装类里面的数值是否相等时，用equals()方法；当测试两个包装类的引用是否指向同一个对象时，用==。
		Integer d1 = 4;
		Integer d2 = 4;
//		System.out.println(d1 == d2);

		String con = "abcdefa";  
		con = con.replace("a", "1");
		System.out.println(con);
		
	}

}
