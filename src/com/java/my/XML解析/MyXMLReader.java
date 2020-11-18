package my.XML解析;

import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * SAX 解析
 * 
 * @author : J
 * @version : Jul 6, 2017 4:18:31 PM explain :
 *          http://blog.csdn.net/sunhuaqiang1/article/details/54984745
 */
public class MyXMLReader extends DefaultHandler {

	// http://www.cnblogs.com/skywang12345/p/3308852.html
	Stack<String> tags = new Stack();

	public MyXMLReader() {
		super();
	}

	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser sp = factory.newSAXParser();
			MyXMLReader reader = new MyXMLReader();
			// 在xml或xsl文件绝对路径之前增加 'file:///'
			sp.parse(new InputSource(
					"file:///D:/work/workspace/test/src/com/my/XML解析/xml.xml"),
					reader);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("运行时间：" + (System.currentTimeMillis() - lasting)
				+ "毫秒");
	}

	/**
	 * 保存节点内容
	 */
	public void characters(char ch[], int start, int length) {

		for (String s : tags) {
			System.out.println("~~~~~~~" + s);
		}

		// 查看此堆栈顶部的对象，而不从堆栈中删除它。
		String tag = (String) tags.peek();

		System.out.println("---------保存节点内容---开始-----");
		if (tag.equals("NO")) {
			System.out.println("车牌号：" + new String(ch, start, length));
		}
		if (tag.equals("ADDR")) {
			System.out.println("地址：" + new String(ch, start, length));
		}
		System.out.println("---------保存节点内容---结束-----");
	}

	/**
	 * 开始解析节点
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		System.out.println("————————————————————————————————————————对" + qName
				+ "的解析开始！");
		tags.push(qName);
		System.out.println("元素名：" + qName);
	}

	
	
	
	
	
	
	
	
	
	
	
	// -------------------------------------
	/**
	 * 结束解析节点
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("————————————————————————————————————————对" + qName
				+ "的解析完成！");
	}

	/**
	 * 开始解析文档
	 */
	public void startDocument() throws SAXException {
		System.out.println("++++++++++++++++++++++++++++开始解析文档");
	}

	/**
	 * 文档解析结束
	 */
	public void endDocument() throws SAXException {
		System.out.println("++++++++++++++++++++++++++++文档解析结束");
	}

}
