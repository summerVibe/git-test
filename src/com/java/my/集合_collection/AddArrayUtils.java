package my.集合_collection;

import java.util.Arrays;

/**
 * http://blog.csdn.net/kesalin/article/details/566354
 * 使用System.arraycopy()实现数组之间的复制
 * @author 2017-3-22
 *
 */
public class AddArrayUtils {
	public static String[] addArrayString(String[] arr , String str){
		int size = arr.length;
		String[] s = new String[size+1];
		System.arraycopy(arr,0,s,0,size);
		s[size] = str;
		return s;
	}
	
	public static Object[] addArrayObject(Object[] o, Object oo){
		int size = o.length;
		Object[] NewO = new Object[size+1];
		for(int i=0; i < o.length; i++){
			NewO[i] = o[i];
		}
		NewO[size] = oo;
		return NewO;
	} 
	
	public static void main(String args[]){
		Object[] i = {"a","b","c","d"};
		System.out.println(Arrays.toString(addArrayObject(i, "f")));
	}
}
