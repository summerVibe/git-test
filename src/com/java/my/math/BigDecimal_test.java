package my.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		public BigDecimal add(BigDecimal value);  //加法
//		public BigDecimal subtract(BigDecimal value);  //减法
//		public BigDecimal multiply(BigDecimal value);  //乘法
//		public BigDecimal divide(BigDecimal value);  //除法
//		public BigDecimal compareTo(BigDecimal value);  //数值比较
		
//		BigDecimal v1 = new BigDecimal(2.2);
//		BigDecimal v2 = BigDecimal.valueOf(2.2);
//		BigDecimal v3 = BigDecimal.valueOf(2.3);
		
//		System.out.println("double "+2.2 * 2.2);
//		System.out.println("BigDecimal "+v2.multiply(v3).doubleValue());
		
		// 银行家舍入法  四舍六入五留双
//		BigDecimal bd = new BigDecimal(3.275);
//		BigDecimal i = bd.setScale(2, RoundingMode.HALF_EVEN);
//		System.out.println(i);

		long days = 0;
		BigDecimal decimal = new BigDecimal(String.valueOf((double)0 / 24));
		System.out.println(decimal);
		BigDecimal setScale = decimal.setScale(1,BigDecimal.ROUND_HALF_DOWN);
		System.out.println(">>>>>>>>>   setScale   " + setScale.toString());
		double s = (double)days + setScale.doubleValue();
		System.out.println(">>>>>>>>>   s   " + String.valueOf(s));

	}

}
