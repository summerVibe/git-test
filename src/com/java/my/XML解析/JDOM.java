package my.XML解析;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * @author  : J
 * @version : Jul 7, 2017  1:31:07 PM
 * explain  : http://blog.csdn.net/sunhuaqiang1/article/details/54984745
 */
public class JDOM {
	
	public static void main(String[] args) {
		
		try {
			// JDOM从XML中解析
			SAXBuilder builder = new SAXBuilder();
			// 获得XML文档对象
			Document doc = builder.build(new File("D:/work/workspace/test/src/com/my/XML解析/xml.xml"));
			// 得到文档根元素
			Element ele = doc.getRootElement();
			System.out.println("根元素名称： "+ele.getName());
			// 得到hello子元素下的属性
			List<?> employeeList = ele.getChildren();
			for(int i = 0;i < employeeList.size();i++){
				Element e = (Element) employeeList.get(i);
	            System.out.println("元素名称： "+e.getName());  
			}
			
			Element value = ele.getChild("VALUE");
			System.out.println(value.getText());
			
			List list = value.getAttributes();
			for(int i = 0;i < list.size();i++){
				Attribute attr = (Attribute) list.get(i);
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				
				System.out.println(attrName + "=" + attrValue);
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
