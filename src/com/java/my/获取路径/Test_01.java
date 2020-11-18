package my.获取路径;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author  : J
 * @version : Jul 19, 2017  2:09:29 PM
 * explain  : http://www.cnblogs.com/lostyue/archive/2011/06/27/2091686.html
 */
public class Test_01 {

	public static void main(String[] args) {
		// -----------第一种----
		Test_01 t = new Test_01();
//		System.out.println(t1.getResource());
		
		
		// -----------第二种----
		File directory = new File("");
		try {
			// 获取当前类的所在工程路径; 
			String courseFile = directory.getCanonicalPath();
			// D:\work\workspace\test
//			System.out.println(courseFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// -----------第三种----
		// 获取当前工程src目录下1.txt文件的路径 
//		System.out.println(t.getXmlPath("1.xml"));
//		System.out.println(t.getXmlPath("com/my/获取路径/2.xml"));
		
		// -----------第四种----
		// 获取当前工程路径 
		// http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
//		System.out.println(System.getProperty("user.dir"));
		
		// -----------第五种----
		// 获取当前工程路径
		System.out.println( System.getProperty("java.class.path")); 
		
		
		//---------------------Class.getResource()-------------------------
		// 当前类(class)所在的包目录
		URL s = Test_01.class.getResource("");
//		System.out.println(s.toString());
		
		// class path根目录
		URL s1 = Test_01.class.getResource("/");
//		System.out.println(s1.toString());
		
		// 1.xml  在bin目录（class根目录）  
		URL s2 = Test_01.class.getResource("/1.xml");
//		System.out.println(s2.toString());
		
		// 2.xml  在 /获取类路径包 中
		URL s3 = Test_01.class.getResource("2.xml");
//		System.out.println(s3.toString());
		
		// 2.xml  在 /获取类路径包 中
		URL s4 = Test_01.class.getResource("pa/3.xml");
//		System.out.println(s4.toString());
		//---------------------Class.getResource()-------------------------
		
	}
	
	public String getResource(){
		
		// 获取当前类的所在工程路径; 
		// /D:/work/workspace/test/bin/
		String s1 = this.getClass().getResource("/").getPath();
		
		// 不加"/"  获取当前类的绝对路径； 
		// /D:/work/workspace/test/bin/com/my/%e8%8e%b7%e5%8f%96%e8%b7%af%e5%be%84/
		String s2 = this.getClass().getResource("").getPath();
		return s1;
	}
	
	public String getXmlPath(String xml){
		//  获取当前工程src目录下文件的路径 
		URL xmlPath = this.getClass().getClassLoader().getResource(xml);
		return xmlPath.toString();
	}
	
}
