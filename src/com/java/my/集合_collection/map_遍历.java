package my.集合_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map 遍历
 * @author  : J
 * @version : Apr 21, 2017  9:42:29 AM
 * explain  : http://blog.csdn.net/liu826710/article/details/9001254
 * 			  http://www.cnblogs.com/leskang/p/6031282.html
 */
public class map_遍历 {
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "张三");
		map.put("2", "李四");
		map.put("3", "王五");
		
		/**     values()        */
		// values():方法是获取集合中的所有的值----没有键，没有对应关系
		Collection<String> collection = map.values();
//		System.out.println(collection);
		
		
		
		/**     KeySet():        */
		// 获取map集合的所有 键 的Set集合
		Set<String> keySet = map.keySet();
		// 获取迭代器
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			String value = map.get(key);
//			System.out.println("key: "+key+"   value:"+value);
		}
		
		
		
		/**      entrySet()：       */
		// 通过entrySet()方法将map集合中的映射关系取出（这个关系就是Map.Entry类型）
		Set<Map.Entry<String, String>> en = map.entrySet();
		Iterator<Map.Entry<String, String>> it = en.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> m = it.next();
			String key2 = m.getKey();
			String value2 = m.getValue();
//			System.out.println("key2: "+key2+"   value2:"+value2);
		}
		
	}

}
