package my.test;
/**
 * @author  : J
 * @version : May 12, 2017  4:55:57 PM
 * explain  : 爱因斯坦台阶问题
 */
public class 台阶问题 {
	
	public static void main(String[] args) {
		for(int i = 1;i<1000;i++){
			if(i%2 == 1 && i%3 == 2 && i%4 == 3 && i%5 == 4 && i%6 == 5 && i%7 == 0){
				System.out.println(i);
			}
		}
	}
}
