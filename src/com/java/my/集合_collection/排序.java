package my.集合_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author  : J
 * @version : Jul 5, 2017  5:11:44 PM
 * explain  : http://blog.csdn.net/sunhuaqiang1/article/details/52142873
 */
public class 排序 {
	
	public static void main(String[] args) {
		
		//数组转集合
		List<Integer> list = Arrays.asList(2,4,1,8,5,6,7,9,1);
		
		// 最大值
//		System.out.println(Collections.max(list));
		
		// 从小到大排序
//		Collections.sort(list);
//		System.out.println(list);
		
		// 随机排序
//		Collections.shuffle(list);
//		System.out.println(list);
		
		//将list中的1使用0来代替
//		Collections.replaceAll(list,1,0); 
//		System.out.println(list);
		
		//判断1在List集合中出现的次数  
//		System.out.println(Collections.frequency(list,1));
		
		//使用两分法查询，只有对先List排好序才能用二分法查找
//		System.out.println(Collections.binarySearch(list,1));
	
		// 反转指定List集合中元素的顺序
//		Collections.reverse(list);
//		System.out.println(list);
		
		// 利用reverseOrder倒序
//        Collections.sort(list, Collections.reverseOrder());
//        System.out.println(list);
		
		
		
		
		// 将指定List集合中i处元素和j出元素进行交换
//		Collections.swap(list, 1, 2);
//		System.out.println(list);
		
		List<String> list1 = new ArrayList<String>();  
        List<String> list2 = new ArrayList<String>(); 
		
        // addAll增加变长参数  
        Collections.addAll(list1, "大家好", "你好","我也好");  
        Collections.addAll(list2, "大家好", "a李四","我也好");  
		System.out.println(list1);
		System.out.println(list2);
		
		// disjoint检查两个Collection是否的交集  
        boolean b1 = Collections.disjoint(list1, list2);  
        System.out.println(b1);  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
