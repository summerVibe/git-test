package my.other;
/**
 * @author  : J
 * @version : Aug 9, 2017  3:38:50 PM
 * explain  : 
 */
public class EqualsTest {

	public static void main(String[] args) {
		
		String s1 = new String("2000");
        String s2 = new String("2000");
        Integer i1 =2000;
        Integer i2 =2000;
//        System.out.println(s1 == s2);
//        System.out.println(s1.toString() == s2.toString());
//        System.out.println(s1.toString().equals(s2));
        System.out.println(s1.equals(i1));
        System.out.println(i2.equals(i1));
	}

}
