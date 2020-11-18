package my.反射;

import java.io.Serializable;

/**
 * @author  : J
 * @version : 2017年6月15日  下午3:03:07
 * explain  : 
 */
public class Student implements Serializable{
	public String name;
	public String sex;
	private int age;
	
	public String getName(String name){
		return "我叫： "+ name;
	}
}
