package my.算法.递归;
/**
 * @author  : J
 * @version : May 9, 2017  9:37:55 AM
 * explain  : 
 */
public class 斐波那契 {
	
	public static int f(int n){
		if(n == 1 || n == 2){
			return 1;
		}
		else{
			return f(n-1) + f(n-2);
		}
	}
	
	public static void main(String[] args){
		f(40);
		System.out.println(f(40));
	}
}
