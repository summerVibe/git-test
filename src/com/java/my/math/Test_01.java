package my.math;

import org.junit.Test;

public class Test_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//round方法 +0.5   然后向下取整。
		System.out.println(Math.round(2.1));
		System.out.println(Math.round(-2.9));
		
		//向下取整。
		System.out.println(Math.floor(-2.5));
		
		//向上取整。
		System.out.println(Math.ceil(2.1));
	}
	
	@Test
	public void random(){
		System.out.println((int)((Math.random()*9+1)*100000));  
	}

}
