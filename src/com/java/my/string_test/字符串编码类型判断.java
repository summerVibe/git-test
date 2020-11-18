package my.string_test;

import java.io.UnsupportedEncodingException;

/**
 * @author  : J
 * @version : Jul 5, 2017  3:43:46 PM
 * explain  : 
 */
public class 字符串编码类型判断 {
	
	public static void main(String[] args) {
		
		// 你好	GB2312
		// ���	UTF-8
		// ÄãºÃ	ISO-8859-1
		System.out.println(getEncoding("你好"));
	
	}
	
	public static String getEncoding(String str){
		
		String encode = "GB2312";
		try {
			if(str.equals(new String(str.getBytes(encode),encode))){
				String s = encode;
				return s;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		 encode = "ISO-8859-1";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {        
	               String s1 = encode;        
	              return s1;        
	           }        
	       } catch (Exception exception1) {        
	       }        
	       encode = "UTF-8";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {        
	               String s2 = encode;        
	              return s2;        
	           }        
	       } catch (Exception exception2) {        
	       }        
	       encode = "GBK";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {        
	               String s3 = encode;        
	              return s3;        
	           }        
	       } catch (Exception exception3) {        
	       }       
		return "";
	}

}
