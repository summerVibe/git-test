package my.集合_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author  : J
 * @version : Jul 21, 2017  4:54:36 PM
 * explain  : 
 */
public class List_遍历 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		// 1.迭代器
		for(Iterator iterator = list.iterator();iterator.hasNext();){                    
		    int i = (Integer) iterator.next();                   
		    System.out.println(i);               
		}
		// 
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
		    int i = (Integer) iterator.next();
		    System.out.println(i);
		}
		
		// 2. foreach
		for (Object object : list) { 
		    System.out.println(object); 
		}
		
		// 3. for循环
		for(int i = 0 ;i<list.size();i++) {  
		    int j= (Integer) list.get(i);
		    System.out.println(j);  
		}
	}
}
