package my.算法.排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : J
 * @version : Jun 29, 2017 11:10:13 AM explain :
 */
public class BubbleSorter implements Sorter {
	
	public static void main(String[] args) {
		Integer[] i = {3,2,6,1,4,9};
		
		BubbleSorter b = new BubbleSorter();
		b.sort(i);
		System.out.println(Arrays.toString(i));
	}
	

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		boolean swapped = true;
		for (int i = 1, len = list.length; i < len && swapped; ++i) {
			swapped = false;
			for (int j = 0; j < len - i; ++j) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					T temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> comp) {
		boolean swapped = true;
		for (int i = 1, len = list.length; i < len && swapped; ++i) {
			swapped = false;
			for (int j = 0; j < len - i; ++j) {
				if (comp.compare(list[j], list[j + 1]) > 0) {
					T temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
		}
	}

}
