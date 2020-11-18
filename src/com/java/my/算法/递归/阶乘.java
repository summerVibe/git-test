package my.算法.递归;
/**
 * @author  : J
 * @version : May 9, 2017  9:45:34 AM
 * explain  : 
 */
public class 阶乘 {

	public static int f(int i){
		if(i == 1){
			return 1;
		}else{
			return i * f(i - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f(5));
	}
}
