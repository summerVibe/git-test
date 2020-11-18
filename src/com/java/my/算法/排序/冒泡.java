package my.算法.排序;

import java.util.Arrays;
import java.util.Random;

/**
 * @author  : J
 * @version : Apr 27, 2017  3:13:11 PM
 * explain  : 随机取10个 1-100的整数放入数组,冒泡排序
 */
public class 冒泡 {
	
	// 随机取10个 1-100的整数放入数组
	public static int[] random(){
		int[] arrays = new int[10];
		for(int j = 0; j < 10; j++){
//			int i = (int) (Math.random()*100) + 1;
			int i = new Random().nextInt(100) + 1;
			arrays[j] = i;
		}
		return arrays;
	}
	
	public static int[] sort(int[] arrays){
		int length = arrays.length;
		int temp ; 
		
		// 循环比较数组前后两值的大小
		for(int i = 0; i < length - 1; i++){
			for(int j = i+1 ; j < length; j++){
				if(arrays[i] < arrays[j]){
					temp = arrays[j];
					arrays[j] = arrays[i];
					arrays[i] = temp;
				}
			}
		}
		return arrays;
	}
	
	public static void main(String[] args) {
		
		System.out.println("冒泡排序： "+Arrays.toString(冒泡.sort(冒泡.random())));
		
		
		int[] aa ={19, 16, 11, 41, 40, 46, 55, 58, 69, 95};
		Arrays.sort(aa);
		System.out.println("快速排序： "+Arrays.toString(aa));
	}
}
