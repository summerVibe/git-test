package my;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  : J
 * @version : May 12, 2017  11:09:52 AM
 * explain  : 
 */
public class Test {
//	public static void main(String[] args) {
		
//		// 科学（指数）计数法
//		long i = (long) 123e5;
//		System.out.println(i);
		
//		float x ;
//		x = 10/4;
//		System.out.println(x);
//		
//		double d = 3.90; 
//		int n = (int)d;  
//		System.out.println(n);
//		
//		short s1 = 1 + 2 ;

//		String s = "A C F R G H";
//		System.out.println(s.length());
//		String ss = s.replace(" ", "");
//		System.out.println(ss.length());

//		String s1 = new String("haha");
//		String s2 = new String("haha");
//		String s3 = "haha";
//		String s4 = s1;
//		System.out.println(s3 == s2);
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s4);
		
//		Thread t = new Thread() {
//
//            public void run() {
//                pong();
//            }
//        };
//
//        t.run();
//        System.out.print("ping");

//		System.out.printf("Name: %s, Age:%d\n", "张三", 24);
		
//		for (int j = 0; j < 100; j++) {
//			System.out.println(new Random().nextInt(10));// 取 0~9的随机整数
//			System.out.println((int) (Math.random()*100) + 1);// 取 0~9的随机整数
//		}
//	}
//	static void pong() {
//        System.out.print("pong");
//    }
	
	
//	@org.junit.Test
	public void getpath(){
		
		System.out.println(System.getProperty("file.separator"));
	}
	
//	@org.junit.Test
	public void sa(){
		
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		System.out.print(i == j); //false
	}
	
	
	
//	@org.junit.Test
	public void ssss(){
		int i = 8;
		System.err.println(6|10);
		
	}
	
//	@org.junit.Test
	public  void t(){
		DecimalFormat df=new DecimalFormat("0.0");
			 
			 System.out.println(Float.valueOf(df.format(0.55)));
	}
	
//	@org.junit.Test
	public void t2(){
		
		String s = "1";
		String[] ss = s.split(",");
		for (int i = 0; i < ss.length; i++) {
			System.err.println(ss[i]);
		}
	}
	
//	@org.junit.Test
	public void t3() throws ParseException{
		String date= "2018-06-10";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(date);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Test.t3()"+sdf2.format(d));
	}
	
	
//	@org.junit.Test
	public void t4() throws ParseException{
//		String s = "?contentId=29&cloudSessionId=c808f49a-b210-0001-165d-13b082701c84&cloudUserId=c7fa6073-ccb0-0001-9c14-1606136c4360&channelCode=1&title=%E4%BA%A4%E4%BB%98%E5%89%8Dbanner&decs=&imageUrl=http%3A%2F%2F118.122.93.246%3A58080%2Fres%2Fimage%2F0%2F356c7df73b0cb6f558764b6445bdfb7f_58.png&isShow=1";
		String s = "0";
		if(1==1){
			s = new DecimalFormat("0.00").format(Float.valueOf("1868.999"));
		}
	System.out.println(s);
	}


	public static Double setUpRate(String score,String lastMonthScore){
		Double score1 =  Double.valueOf(score);
		Double score2 =  Double.valueOf(lastMonthScore);
		BigDecimal big = new BigDecimal(0);
//		if (score2 != 0){
			big =  new BigDecimal(score1).divide(new BigDecimal(score2),10,BigDecimal.ROUND_HALF_DOWN);
			big = big.subtract(new BigDecimal(1)).setScale(2,BigDecimal.ROUND_HALF_UP);
//		}
		System.out.println(big.toString());
		return big.doubleValue();
	}

	public static void main(String[] args) {
//		setUpRate("0","110");
//		BigDecimal big = new BigDecimal("null");
//		System.out.println(big.toString());

//		System.out.println(new BigDecimal(0.0).compareTo(new BigDecimal(0))==0);
		BigDecimal bxScore = new BigDecimal(0);
		bxScore = bxScore.add(new BigDecimal(100));
		System.out.println(bxScore.toString());
	}


//	@org.junit.Test
	public void t5(){
		String s = "1,2,1";
		s = ","+s+",";
		System.out.println(s+"-----"+s.indexOf(",1,"));
		if(s.indexOf(",1,") != -1){
			System.out.println("00000000");
		}
	}

//	@org.junit.Test
	public void t6(){
		String code = "D2143569-2";

//		if(code == null || code.length() < 8){
//			System.out.println("--------长度不正确");
//		}

		int[] ws = { 3, 7, 9, 10, 5, 8, 4, 2 };
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String regex = "^([0-9A-Z]){8}-[0-9|X]$";

		if (!code.matches(regex)) {
			System.out.println("----不符合校验组织机构代码规则----");
		}else{
			int sum = 0;
			for (int i = 0; i < 8; i++) {
				sum += str.indexOf(String.valueOf(code.charAt(i))) * ws[i];
			}
//		logger.info("sum is {}", sum);
//		logger.info("sum % 11 is {}", sum % 11);

			int c9 = 11 - (sum % 11);

			String sc9 = String.valueOf(c9);
			if (11 == c9) {
				sc9 = "0";
			} else if (10 == c9) {
				sc9 = "X";
			}
			System.out.println("--------"+sc9.equals(String.valueOf(code.charAt(9))));
		}
//		logger.info("sc9 is {}", sc9);
//		return sc9.equals(String.valueOf(code.charAt(9)));

	}
	@org.junit.Test
	public void t7(){
		int i1 = 1;

		int i2 = 2;
		double d1 = (double)i1/i2;
		System.out.println(d1);

		StringBuffer sb = new StringBuffer();
	}


}
