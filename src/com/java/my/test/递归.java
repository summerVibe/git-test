package my.test;

import java.math.BigDecimal;

/**
 * 解释：程序调用自身的编程技巧叫做递归。
 * @author thinkpad
 *		http://www.2cto.com/kf/201301/181639.html
 *		http://blog.csdn.net/bbirdsky/article/details/8964560
 */
public class 递归 {
	
	//递归求阶乘
	public static int diGui(int i){
		if(i == 1){
			return 1;
		}else{
			//System.out.println(i*diGui(i-1)+" ");
			return i*diGui(i-1);
		}
	}
	
	//for循环求阶乘
	public static int f(int n){
		int sum = 1;
		for(long i=n; i > 0; i--){
			sum *= i;
		}
		return sum;
	}
	
	//BigDecimal.multiply(i_value)  乘法，数值大时使用
	public static BigDecimal b(int b){
		 BigDecimal result= new BigDecimal(1);
		  for(int i=1;i<=b;i++){
		   BigDecimal i_value= new BigDecimal(i);
		   result = result.multiply(i_value);
		  }
		return result;
		
	}
	 
	//递归法-斐波那契数列
	 public static int feiBoNaQie(int n ) {  
	        if (1 == n || 2 == n){
	        	 return 1;  
	        }  
	        else{
	        	return feiBoNaQie(n-1) + feiBoNaQie(n-2);  
	        }  
	    }
	 
	 //递推法-斐波那契数列
	 public static int diTui(int d){
		 int n1 = 1;
		 int n2 = 1;
		 int sum = 0;
		 
		 for(int i = 0; i < d-2; i++ ){
			 sum = n1 + n2;
			 n1 = n2;
			 n2 = sum;
		 }
		return sum;
	 }
	 
	 
	
	public static void main(String[] args){
//		System.out.println("递归求阶乘--"+diGui(10));
//		System.out.println("for循环求阶乘--"+f(10));
//		System.out.println("循环求阶乘--"+b(10));
		System.out.println("递归-斐波那契数列--"+feiBoNaQie(30));
		System.out.println("递推-斐波那契数列--"+diTui(30));
	}
}
