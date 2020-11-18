package my.包装类;
/**
 * @author  : J
 * @version : Jul 21, 2017  10:46:02 AM
 * explain  : http://blog.csdn.net/sunhuaqiang1/article/details/51958618
 */
public class Test_01 {
	public static void main(String[] args) {
		
		int i = 127;
		
		Integer i1 = new Integer(127);
		Integer i2 = new Integer(127);
//		System.out.println(i1 == i2);// false	new...
		
		Integer i3 = 127;
//		System.out.println(i1 == i3);// false	new...
		
		// Integer和int比较都会自动拆箱（jdk1.5以上）
		System.out.println(i == i1);// true
		System.out.println(i == i3);// true
		
		
		// 对于-128到127之间的数，会进行缓存，Integer i3 = 127时，会将127进行缓存，
		// 下次再写Integer i4 = 127时，就会直接从缓存中取，就不会new了。
		Integer i4 = 127;
//		System.out.println(i3 == i4);// true	
		
		Integer i5 = 128;
		Integer i6 = 128;
//		System.out.println(i5 == i6);// false	
		
		
		/**
		 * 总结：
		 * 1.无论如何，Integer与new Integer不会相等。不会经历拆箱过程
		 * 
		 * 2.两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false。
		 * 	java在编译Integer i2 = 128的时候,被翻译成-> Integer i2 = Integer.valueOf(128);
		 *  而valueOf()函数会对-128到127之间的数进行缓存。
		 *  
		 * 3.两个都是new出来的,都为false。
		 * 
		 * 4.int和integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比;
		 */
		
		
		
		
		
		
		
		
		
		
	}

}
