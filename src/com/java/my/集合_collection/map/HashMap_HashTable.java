package my.集合_collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author  : J
 * @version : Jul 26, 2017  2:40:46 PM
 * explain  : 
 */
public class HashMap_HashTable {

	@org.junit.Test
	public void t1(){
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put(null, null);
		Map<String, String> m2 = new Hashtable<>();
		m1.put(null, null);
		
		System.out.println(m2.put("s", "s"));
	}



	@org.junit.Test
	public void t2(){
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("1", "11111111");
		m1.keySet();
		System.out.println(m1.keySet() + "    "+m1.get(m1.keySet()));
	}
}
