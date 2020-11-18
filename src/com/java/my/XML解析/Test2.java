package my.XML解析;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/** 
 * @author  J
 * @date 创建时间：Jan 12, 2018 - 5:02:44 PM
 * @version 1.0 
 */
public class Test2 {

	public static void main(String[] args) {
		Map map = new HashMap();
		String xml = "<data><birthday>1988-10-02</birthday><result>1</result><idtype>1</idtype><sex>0</sex><txcode>1PBL004</txcode><cusver>2</cusver><source>16</source><qqqd>16</qqqd><homeplace></homeplace><resmsg>调用成功</resmsg><resident>1515746779957</resident><perstate>0</perstate><txchannel>16</txchannel><flag>1</flag><nation>1</nation><torgcode>cdgjj</torgcode><reqfilemny>0</reqfilemny><idcard>510129198810022119</idcard><fixedphone>028-88285666</fixedphone><msg>调用成功</msg><pername>高祥然</pername><forgcode>bea2d047f193d4eb6ad2</forgcode><remark>个人账户于10-2月-14设立</remark><clientinfo>localhost:5080trader-bank2-TEST1-6</clientinfo><percode>220143266525</percode><resfilemny>0</resfilemny><reqident>SPDBCD730125000005</reqident><signflag>0</signflag><rescode>1</rescode></data>";
		try {
			Document doc  = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement(); 
			Element element = rootElt.element("birthday");
			String s = element.getText();
			System.out.println(s);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
}
