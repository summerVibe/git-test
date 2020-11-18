package my.document_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author  : J
 * @version : Jun 29, 2017  4:57:47 PM
 * explain  : 
 */
public class Document_02 {
	
	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
	    //获取类加载器
	    ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    //获取文件流
	    InputStream inputStream = loader.getResourceAsStream("/t.xml");
//	    System.out.println(inputStream);
	    
	    File file = new File("D:/work/workspace/test/src/com/my/document_test/t.xml");
	    FileInputStream in;
		try {
			in = new FileInputStream(file);
			byte[] b = new byte[1024];
			in.read(b, 0, b.length);
//			System.out.println(new String(b));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    //创建document对象
	    try {
			Document doc = reader.read(inputStream);
//			System.out.println(doc.asXML());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
