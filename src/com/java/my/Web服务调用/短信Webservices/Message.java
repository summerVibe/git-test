package my.Web服务调用.短信Webservices;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
/** 
 * @author  J
 * @date 创建时间：Oct 9, 2017 - 11:01:18 AM
 * @version 1.0 
 */
public class Message {
	
    @Test
    public void sendSms() throws Exception {
    	XML_Utils xu  = new XML_Utils();
        String urlString = "http://221.237.182.5:8088/Service.asmx";
        String xml = xu.sendMessagetoXml("15", "SmsMail331", "1", 4, "15608099852", "测试");
        String soapActionString = "http://tempuri.org/sendMessage";
        URL url = new URL(urlString);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        byte[] b = xml.getBytes();//String转换为byte[] 
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("soapActionString", soapActionString);
        httpConn.setRequestMethod("POST");// 请求方式
        httpConn.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
        httpConn.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
        httpConn.setUseCaches(false);// Post 请求不能使用缓存
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();

        byte[] datas=readInputStream(httpConn.getInputStream());
        String result=new String(datas);
        System.out.println("result   "+result(result));
        
        //打印返回结果
        System.out.println("result:" + result);
    }

    /**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }

    public static String result(String result) throws UnsupportedEncodingException {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
			Element rootele = doc.getRootElement();
//			System.out.println("doc.getRootElement()   "+rootele.toString());
			List<Element> childElements = rootele.elements();//获取当前元素下的全部子元素  
	        for (Element child : childElements) {//循环输出全部book的相关信息  
	            List<Element> res = child.elements();  
	            for (Element re : res) {  
//	                String name = re.getName();//获取当前元素名  
//	                String text = re.getText();//获取当前元素值  
//	                System.out.println(name + ":" + text);  
	                
	                Element r = re.element("sendMessageResult");
	                String n = r.getName();
	                String t = r.getText();
//	                System.out.println(n + ":" + t);  
	                return t;
	            }  
	        } 
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
