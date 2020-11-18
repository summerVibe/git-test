package my.反射;

import java.lang.reflect.Method;


/**
 * @author  : J
 * @version : 2017年6月15日  下午3:05:27
 * explain  : 
 */
public class Test_01 {
	public static void main(String[] args) {
		try {
			
			// 最常用方式
			Class<?> c1 = Class.forName("com.my.反射.Student");
			Class<?> c2 = new Student().getClass();
			Class<?> c3 = Student.class;
//			System.out.println("类名称   " + c1.getName());
//	        System.out.println("类名称   " + c2.getName());
//	        System.out.println("类名称   " + c3.getName());
			
			// 取得父类
	        Class<?> parentClass = c1.getSuperclass();
//	        System.out.println("c1的父类为：" + parentClass.getName());
	        
	        // 获取所有的接口
	        Class<?>[] interfaces = c1.getInterfaces();
	        System.out.println("c1实现的接口有：");
	        for (int i = 0; i < interfaces.length; i++) {
	            System.out.println((i + 1) + "：    " + interfaces[i].getName());
	        }
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
