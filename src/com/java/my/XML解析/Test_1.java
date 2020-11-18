package my.XML解析;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/** 
 * @author  J
 * @date 创建时间：Jan 12, 2018 - 4:52:18 PM
 * @version 1.0 
 */
public class Test_1 {
	
	public static void main(String[] args) {
		File file = new File("C:/Users/Administrator/Desktop/111.xml");
		System.out.println(file.getParent());// 返回文件父目录路径。 --c:\Users\thinkpad\Desktop
		try {
			// http://www.cnblogs.com/huangyibo/p/3667714.html
			System.out.println(file.createNewFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			
			FileReader in = new FileReader(file);
			char[] c = new char[1000];
			in.read(c);
			
			
			
			String sss = new String(c);
			
			 
			
			
			System.out.println(" 读取：  "+sss);
			
			c.clone();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	

}
