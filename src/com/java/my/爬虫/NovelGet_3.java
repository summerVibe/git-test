package my.爬虫;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  : J
 * @version : Jul 17, 2017  2:15:44 PM
 * explain  :   努努书坊    罪全书
 */
public class NovelGet_3 {
	
	public static void main(String[] args) {
		// 零点看书	唐砖
		String baseUrl = "http://www.kanunu8.com/book/4609/";
        String nextUrl = "58639.html";	// 第一章
        String destFilePath = "D:\\罪全书.txt";
		
        System.out.println("开始爬取数据...");
        long startTime = System.currentTimeMillis();
        getNovel(baseUrl, nextUrl, destFilePath);
        long endTime = System.currentTimeMillis();
        System.out.println("爬取数据完成...");
        System.out.println("用时 " + (endTime - startTime) / 1000 + "秒...");
    }

    public static void getNovel(String baseUrl, String nextUrl, String destFilePath) {
       
    	FileWriter fw = null;
    	try {
            File destFile = new File(destFilePath);
            // 目标文件存在则删除
            if (!destFile.exists()) {
                destFile.delete();
            }
            destFile.createNewFile();

            fw = new FileWriter(destFile);
            
            String realUrl, resultContent;
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            // 正文正则匹配表达式
//            Pattern contentPat = Pattern.compile("<div id=\"nr1\">(.+?)</div>");
            Pattern contentPat = Pattern.compile("(<p>)\\s*第(\\w*|\\W*|[\\u4e00-\\u9fa5]){0,}(</p>)");
            
            
            
            // 标题正则表达式
//            Pattern titlePat = Pattern.compile("<div class=\"nr_title\" id=\"nr_title\">(.+?)</div>");
//            Pattern titlePat = Pattern.compile("<p>\\s*第<br>");
            
            // 下一章正则表达式
//            Pattern nextPat = Pattern.compile("<a id=\"pb_next\" href=\"(.+?)\">");
            
            // <a href="58639.html">上一页</a>
            Pattern nextPat = Pattern.compile("<a href=\"(.+?)\">下一页</a>");
            
            Matcher matcher;
            // 下一张的url以 / 开头则是最新章节
            while (!nextUrl.startsWith("/")) {
                realUrl = baseUrl + nextUrl;
                
                // 获取目标url的response   读取中文时需要用GBK,否则会出现乱码
                br = new BufferedReader(new InputStreamReader(new URL(realUrl).openStream(),"GBK"));
                
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                // 替换空格和换行符
                resultContent = sb.toString().replaceAll("&nbsp;", "").replaceAll("<br/><br/>", "*****");
                // 换行
                fw.write("\r\n\r\n");
//                // 匹配标题
//                matcher = titlePat.matcher(resultContent);
//                if (matcher.find()) {
//                    fw.write("-------------"+matcher.group(1)+"-------------");
//                }
                fw.write("\r\n");
                // 匹配正文
                matcher = contentPat.matcher(resultContent);
                if (matcher.find()) {
                    fw.write(matcher.group(1));
                }
                // 匹配下一页url
                matcher = nextPat.matcher(resultContent);
                if (matcher.find()) {
                    nextUrl = matcher.group(1).substring(13, matcher.group(1).length());
//                    System.out.println(nextUrl);
                    if("/html/1/1115/".equals(matcher.group(1))){
                    	if (br != null) {
                            br.close();
                        }
                        fw.close();
                        return;
                    }
                }
                // 清空
                sb.delete(0, sb.length());
            }
            if (br != null) {
                br.close();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	try {
        		if(fw != null){
        			fw.close();
        		}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
}
