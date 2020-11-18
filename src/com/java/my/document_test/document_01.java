package my.document_test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class document_01 {

	/**
	 * 转义符"\""
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Document document = null;
		String x = "\"\"\"\"";
//		<env:Envelope xmlns:env="http://schemas.xmlsoap.org/soap/envelope/">
//		<env:Header/>
//		<env:Body>
//			<OutputParameters xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_logistics_pkg/get_inv_quantity/">
//				<X_REQUEST_CODE xsi:nil="true"/>
//				<X_RETURN_STATUS>S</X_RETURN_STATUS>
//				<X_RETURN_MSG xsi:nil="true"/>
//				<X_QTY>137</X_QTY>
//			</OutputParameters>
//		</env:Body>
//		</env:Envelope>
		
		String xml = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header/><env:Body><OutputParameters xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_logistics_pkg/get_inv_quantity/\"><X_REQUEST_CODE xsi:nil=\"true\"/><X_RETURN_STATUS>S</X_RETURN_STATUS><X_RETURN_MSG xsi:nil=\"true\"/><X_QTY>137</X_QTY></OutputParameters></env:Body></env:Envelope>";
		
		
		try {
			document = DocumentHelper.parseText(xml);
//			System.out.println(document.asXML());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element e = document.getRootElement();
		Element e2=e.element("Body");
		Element e3=e.element("X_REQUEST_CODE");
//		System.out.println(e);
//		System.out.println(x);
//		System.out.println(e3);
	}

}
