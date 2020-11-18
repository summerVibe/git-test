package my.XML解析;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author : J
 * @version : Jul 6, 2017 3:50:38 PM explain :
 *          http://blog.csdn.net/sunhuaqiang1/article/details/54984745
 */
public class DOM {

	public static void main(String[] args) {

		// TODO 哈哈
		try {
			File f = new File("D:/work/workspace/test/src/com/my/XML解析/xml.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList n1 = doc.getElementsByTagName("VALUE");
			for (int i = 0; i < n1.getLength(); i++) {
				System.out.println("车牌号："
						+ doc.getElementsByTagName("NO").item(i)
								.getFirstChild().getNodeValue());
				System.out.println("车主地址:"
						+ doc.getElementsByTagName("ADDR").item(i)
								.getFirstChild().getNodeValue());
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
