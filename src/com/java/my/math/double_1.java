package my.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

public class double_1 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		double f1 = 111231.5586;
		double f2 = 0.0;
		BigDecimal b1 = new BigDecimal(f1);
		BigDecimal b2 = new BigDecimal(f2);
		/*保留两位小数，四舍五入。*/
		double ff1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double ff2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(ff1+"\n"+ff2);

		double d1 = 111231.5586;
		double d2 = 0.0;
		double d3 = 2.0;
		DecimalFormat de = new DecimalFormat("######.000");
		String s1 = de.format(d1);
		String s2 = de.format(d2);
		String s3 = de.format(d3);
		System.out.println(s1+"\n"+s2+"\n"+s3);
	
		
	}
	
	
	@Test
	public void test(){
		long s = 120l;
		int i = 30;
		
		double d = (double)i / s;
		System.out.println(d);
		
		
	}
}
