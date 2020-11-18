package my.string_test;

public class intern_ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);// false
        System.out.println(s1 == s5);// true
        System.out.println(s1 == s6);// false
        // JDK1.7中，intern方法不会再复制实例，而是在常量池中记录首次出现的字符串(equals())的实例引用。
        System.out.println(s1 == s6.intern());// true
        System.out.println(s2 == s2.intern());// false
        System.out.println(s1 == s2.intern());// true
		
	}

}
