package my.集合_collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  : J
 * @version : 2017年6月20日  下午3:24:23
 * explain  : 
 */
public class 对象转Map {

	public static void main(String[] args) {
		System.out.println(getValueMap(new User()));
	}

	public static Map<String, Object> getValueMap(Object obj){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
		Field[] fields = obj.getClass().getDeclaredFields();
		for(int i = 0, len = fields.length; i < len; i++){
			// 获取属性名
			String varName = fields[i].getName();
			
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				
				// 修改访问控制权限
				fields[i].setAccessible(true);
				
				// 获取在对象f中属性fields[i]对应的对象中的变量
				map.put(varName, fields[i].get(obj));
				fields[i].setAccessible(accessFlag);
			
			} catch (IllegalArgumentException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
}
