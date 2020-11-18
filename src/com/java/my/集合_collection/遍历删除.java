package my.集合_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author  : J
 * @version : Jul 21, 2017  3:32:50 PM
 * explain  : http://www.cnblogs.com/pcheng/p/5336903.html
 */
public class 遍历删除 {
	public static void main(String[] args) {
		test_1();
		
	}
	
	// 对JAVA集合进行遍历删除时务必要用迭代器。
	public static void test_1(){
		List<String> str = new ArrayList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("4");
		System.out.println("-------"+str);
		for(Iterator<String> it = str.iterator(); it.hasNext();){
			String ss = it.next();
			if("3".equals(ss)){
				it.remove();
			}
		}
		System.out.println("++++++++"+str);
	}
	
	// for循环----不可使用
	public static void test_2(){
		List<String> str = new ArrayList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("4");
		System.out.println("-------"+str);
		
		for(int i = 0;i < str.size();i++){
			if("3".equals(str.get(i))){
				str.remove(i);
			}
		}
		System.out.println("++++++++"+str);
	}
	
	// foreach循环(增强for循环)----不可使用
	public static void test_3(){
		List<String> str = new ArrayList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("4");
		System.out.println("-------"+str);
		
		for(String s : str){
			if("3".equals(s)){
				str.remove(s);
			}
		}
		System.out.println("++++++++"+str);
	}
}
