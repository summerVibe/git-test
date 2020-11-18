package my.XML解析;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author  : J
 * @version : Jul 7, 2017  1:34:05 PM
 * explain  : 
 */
public class DOM4J {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("D:/work/workspace/test/src/com/my/XML解析/xml.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element ele = doc.getRootElement();
			Element foo ;
			
			for(Iterator i = ele.elementIterator("VALUE");i.hasNext();){
				foo = (Element) i.next();
				System.out.println("车牌号码:" + foo.elementText("NO"));
				System.out.println("车主地址:" + foo.elementText("ADDR"));
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
