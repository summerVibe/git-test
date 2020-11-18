package my.爬虫;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  : J
 * @version : Jul 14, 2017  2:35:30 PM
 * explain  : http://www.cnblogs.com/huangwentian/p/6484534.html
 */
public class WebSpider {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlconn = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		try {
//			url = new URL("http://www.sina.com.cn/");
//			url = new URL("https://user.qzone.qq.com/1573949876/infocenter");
			url = new URL("http://www.dnyche.com/driver/list_2");
			
			
			urlconn = url.openConnection();
			pw = new PrintWriter(new FileWriter("D:/url.txt", true));
			br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			String buf = null;
			while((buf = br.readLine()) != null ){
				Matcher buf_m = p.matcher(buf);
				while(buf_m.find()){
					pw.println(buf_m.group());
				}
			}
			System.out.println("获取成功");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
