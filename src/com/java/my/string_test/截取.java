package my.string_test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/** 
 * @author  J
 * @date 创建时间：Oct 17, 2017 - 11:16:31 AM
 * @version 1.0 
 */
public class 截取 {
	
//	@Test
	public void test1(){
		String s = "1.gif";
		String ss = s.substring(0,s.lastIndexOf("."));
		System.out.println(ss);

	}
	
//	@Test
	public void test2(){
		String html = "<p><img src=\"http://localhost:8080/zwemail/upfile/20171018/1508315781459081185.gif\" title=\"1508315781459081185.gif\" alt=\"6D45801BA9286DC2851032FB3B235453.gif\"/><img src=\"http://localhost:8080/zwemail/upfile/20171018/1508315786566091917.png\" title=\"1508315786566091917.png\" alt=\"27$[0~_M`Y0({`YVHW$~VZ6.png\"/></p>";
			
		Document doc = Jsoup.parse(html);
		Elements ele = doc.getElementsByTag("img");
		List<String> srcs = null;
		if(ele != null && ele.size() > 0){
			srcs = new ArrayList<>();
			for(Element e : ele) {
				  String src = e.attr("src"); // 原图片src
				  System.out.println("原src   "+ src);
				  String hz = src.substring(src.lastIndexOf(".")+1);// 后缀名
				  e.attr("src", "$$self$0$"+hz+"$$");// 修改图片src
//				  File f = new File(src);
//				  String abs = f.getAbsolutePath();
//				  srcs.add(src);
				  System.out.println("替换后src   "+e.attr("src"));
			}
			Elements body = doc.getElementsByTag("body");
			for(Element b : body) {
				System.out.println("ok  "+b.html());
			}
		}
	}
	
//	@Test
	public void test3(){
		String s = "317d59b73cb464ad19968d150277fc9b_1508.xls";
		int i = s.lastIndexOf("_");
		int j = s.lastIndexOf(".");
		if (i != -1 && j != -1) {
			s = s.substring(i+1, j);
			System.out.println(s);
		}else {
			System.out.println("文件名格式不正确");
		}
	}
	
	
//	@Test
	public void test4(){
		String s = "0123456789";
		if (s.length() > 8) {
			System.out.println("--------"+s.substring(0, -3));
		}else {
			System.out.println("++++++++"+s);
		}
	 }

	@Test
	public void test5(){
		String s = "|^|visitor|^|88888888";
		String[] ss = s.split("\\|\\^\\|");
		if (ss != null && ss.length > 0){
			System.out.println(ss.length);
			for (int i = 0;i < ss.length;i++){
				System.out.println(ss[i]);
			}
		}
	}

	@Test
	public void test6(){
		String s = ",1,2,3,";
		String[] ss = s.split(",");
		if (ss != null && ss.length > 0){
			System.out.println(ss.length);
			for (int i = 0;i < ss.length;i++){
				System.out.println(ss[i]);
			}
		}
	}

}
