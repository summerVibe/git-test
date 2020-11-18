package my.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class SendEmail_test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Email mail = new Email(false);
		String s = "";
		
		URL url = SendEmail_test01.class.getResource("baidu.html");
		String urlStr = url.toString();
		File file = new File(urlStr.substring(6, urlStr.length()));
		try {
			FileReader in = new FileReader(file);
			BufferedReader i = new BufferedReader(in);
			String str = "";
			String temp = null;
			while((temp = i.readLine()) != null){
				str = str + temp;
			}
			String mailAddress = "info@bbuyaustralia.com";
//			String mailAddress = "1573949876@qq.com";
			mail.doSendHtmlEmail("你好!", str, mailAddress,file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
