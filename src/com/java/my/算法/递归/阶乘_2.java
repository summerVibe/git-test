package my.算法.递归;
/**
 * @author  : J
 * @version : May 12, 2017  5:07:19 PM
 * explain  : 求 1+2!+3!+4!+5!+...+20!
 */
public class 阶乘_2 {
	public static void main(String[] args) {
		System.out.println(2);
		System.out.println(x2(20));
	}
	
	public static int x(int i){
		
		if(i == 1){
			return 1;
		}else{
			return i + x(i-1);
		}
	}
	
	public static int x2(int i){
		if(i == 1){
			return 1;
		}else{
			return x(i) + x(i-1);
		}
	}
}
