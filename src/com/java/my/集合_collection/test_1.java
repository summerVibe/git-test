package my.集合_collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  : J
 * @version : Apr 21, 2017  3:24:55 PM
 * explain  : 随机定义长度为10的数组，求最大、最小、平均值、和值；
 */
public class test_1 {
	public static void main(String[] argv) {
		int[] array = new int[10];
		int i = 0, sum = 0, max, min, temp;
		double avg = 0.0;
		while (i < 10) {
			int j = (int) (Math.random() * 100);
			array[i] = j;
			System.out.println(array[i]);
			i++;
		}
		max = min = array[0];
		i = 0;
		while (i < 10) {
			sum += array[i];
			if (max < array[i]) {
				max = array[i];
			}
			if (min > array[i]) {
				min = array[i];
			}
			i++;
		}
		avg = sum * 1.0 / 11;  //  int/int = int
		System.out.println("最大值" + max);
		System.out.println("最小值" + min);
		System.out.println("平均值" + avg);
		System.out.println("和值" + sum);
		
		
		List<Integer> a = new ArrayList<>(); 
	}
}