package my.集合_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  : J
 * @version : Apr 21, 2017  12:00:21 PM
 * explain  : 
 */
public class Arrary_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1={1,2,3,4};
		int[] a2 = new int[]{1,2,3,4};
		String[] s1={"A","B","",null};
		String[] s2= new String[]{"A","B","",null};
		
		System.out.println(Arrays.equals(a1, a2));
		System.out.println(Arrays.equals(s1, s2));
		
		
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list1.add(2);
		List<int[]> list2 = Arrays.asList(a1);
		
		System.out.println(list1);
		System.out.println();
	}

}
