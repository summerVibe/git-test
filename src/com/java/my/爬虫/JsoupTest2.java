package my.爬虫;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.Charset;


public class JsoupTest2 {
	

	public static void main(String[] args) throws IOException {
		//	http://www.dnyche.com/guide/list_       麦田领车人
		//	http://www.dnyche.com/driver/list_		收割机司机
		getTxts("driver");
	}


	private static void getTxts(String type) throws IOException{
		for(int i=1;i<=2;i++){
			System.out.println("----  http://www.dnyche.com/"+type+"/list_"+i);

			xiaoShuo("http://www.dnyche.com/"+type+"/list_"+i);
		}
	}

	/**
	 * 笔趣主页
	 * @param url
	 * @throws IOException
	 */
	private static void xiaoShuo(String url) throws IOException{
		Document document = connectUrl(url);
		Elements select = document.select(".ul-sub li");
		FileWriter fw = new FileWriter("C:\\Users\\E465\\Desktop\\XXX\\1.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<select.size();i++){
			Element element = select.get(i);
			if(element.getElementsByTag("span").size()!=0){
				System.out.println("=========="+element.getElementsByTag("span").html());
//				System.out.println("=========="+element.getElementsByTag("span").text());
//				BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(element.getElementsByTag("span").text().getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));


				bw.write(element.getElementsByTag("span").text());
				bw.newLine();
//				String line="";
//				while ((line=br.readLine())!=null){
//					String replace = line.replace("&nbsp;", " ").replace("<br>", "");
//					bw.write(replace);
//					bw.newLine();
//				}
				bw.newLine();
				break;

//				System.out.println("========"+element.getElementsByTag("a").get(0).child(0).html());
//				System.out.println("++++++++"+element.getElementsByTag("a").get(0).child(0).attr("value"));
//				xiaoShuoz(element.getElementsByTag("a").get(0).child(0).attr("value"));
			}
		}

	}


	/**
	 * ac 爬取主页
	 * @param url
	 * @throws IOException
	 */
	private static void connectAc(String url) throws IOException{
		//		Document doc = Jsoup.connect("http://www.acfun.cn/")
		//		  .data("query", "Java")
		//		  .userAgent("Mozilla")
		//		  .cookie("auth", "token")
		//		  .timeout(3000)
		//		  .post();
		//Document startdoc=Jsoup.connect(urlstr)
		//		.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
		//		.timeout(10000)
		//		.get();
		//System.out.println(doc.html());
		//Connection connect = Jsoup.connect("http://www.acfun.cn/");
		//Document document = connect.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
		//							.data("query", "Java")
		//							  .userAgent("Mozilla")
		//								.ignoreHttpErrors(true)
		//							  .cookie("auth", "token")
		//							  .timeout(3000)
		//							.get();
		Document document = connectUrl(url);
		Elements select = document.select(".wp .column-left .area-main figure");
		for(int i=0;i<select.size();i++){
			Element element = select.get(i);
			System.out.println(element.select("figcaption a").attr("title"));
			System.out.println("http://www.acfun.cn/"+element.select("a").attr("href"));
			selecl("http://www.acfun.cn/"+element.select("a").attr("href"));
		}
	}
	/**
	 * ac 爬取主页
	 * @param string
	 * @throws IOException
	 */
	private static void selecl(String string) throws IOException {
		Document document = connectUrl(string);
		Elements select = document.select(".part a");
		if(!"".equals(select)){
			for(int i=0;i<select.size();i++){
				Element element = select.get(i);
				System.out.println("element.attr('title')---------------------"+element.attr("title"));
				System.out.println("element.attr('href')---------------------"+"http://www.acfun.cn/"+element.attr("href"));
			}
		}
	}
	/**
	 * jsoup 链接
	 * @param url
	 * @return doc
	 */
	private static Document connectUrl(String url){
		Document document=null;
		try {
			 document = Jsoup.connect(url)
				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
				.ignoreHttpErrors(true)
				.cookie("auth", "token")
				.timeout(30000000)
				.referrer("http://www.dnyche.com/")
				.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}


	/**
	 * 笔趣 小说主页
	 * @param url
	 * @throws IOException 
	 */
	private static void xiaoShuoz(String url) throws IOException{
		Document document = connectUrl(url);
		Elements select = document.select(".btnlinks");
		for(int i = 0; i<select.size();i++){
			Element element = select.get(i);
//				System.out.println("-----"+element.child(0));
//				System.out.println("-----"+element.child(0).attr("title"));
//				System.out.println("-----"+element.child(0).attr("href"));
				File file = new File("C:\\Users\\E465\\Desktop\\XXX\\"+element.child(0).attr("title")+".txt");
				if(!file.exists()){
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				xiaoShuozz(element.child(0).attr("href"),fw);
		}
	}
	/**
	 * 笔趣 小说章节
	 * @param url
	 * @param fw 
	 * @throws IOException 
	 */
	private static void xiaoShuozz(String url, FileWriter fw) throws IOException{
		Document document = connectUrl(url);
		Elements select = document.select(".bdsub td a");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<select.size();i++){
			Element element = select.get(i); 
//			System.out.println("------------"+url+element.attr("href"));
//			System.out.println("------------"+element.html());
			xiaoShuozzContent(url+element.attr("href"),bw);
		}
		bw.close();
	}
	/**
	 * 笔趣 小说章节内容
	 * @param url
	 * @param bw 
	 * @param bw 
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void xiaoShuozzContent(String url, BufferedWriter bw) throws IOException{
		
		
		Document document = connectUrl(url);
		Elements title = document.select(".bdsub h1");
		Elements content = document.select(".bdsub #contents");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 for(int i = 0; i<title.size();i++){
			Element title1 = title.get(i);
			Element content1 = content.get(i);
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content1.html().getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));  
			bw.write(title1.html());
			bw.newLine();
			String line=""; 
			while ((line=br.readLine())!=null){
				String replace = line.replace("&nbsp;", " ").replace("<br>", "");
				bw.write(replace);
				bw.newLine();
			}
			bw.newLine();
			break;
		}
		
	}

}
