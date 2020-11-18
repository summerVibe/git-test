package my.集合_collection;

import java.io.Serializable;

/**
 * @author  : J
 * @version : 2017年6月20日  下午3:25:21
 * explain  : 
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7740471609111790271L;
	private String name;
	private int age;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
