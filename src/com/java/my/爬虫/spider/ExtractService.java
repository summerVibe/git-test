package my.爬虫.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @author  : J
 * @version : Jul 14, 2017  4:55:36 PM
 * explain  : http://blog.csdn.net/lmj623565791/article/details/23272657
 */
public class ExtractService {

	public static List<LinkTypeData> extract(Rule rule){
		
		// 验证
		validateRule(rule);
		List<LinkTypeData> datas = new ArrayList<>();
		
		LinkTypeData data = null;
		
		// 解析 Rule
		String url = rule.getUrl();  
        String[] params = rule.getParams();  
        String[] values = rule.getValues();  
        String resultTagName = rule.getResultTagName();  
        int type = rule.getType();  
        int requestType = rule.getRequestMethod();  
		
        Connection conn = Jsoup.connect(url);
		
        // 设置查询参数
        if(params != null){
        	for(int i = 0;i < params.length; i++){
        		conn.data(params[i], values[i]);
        	}
        }
		
        // 设置请求类型
		Document doc = null;
		switch(requestType){
		case Rule.GET:
			try {
				doc = conn.timeout(900000).ignoreContentType(true).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case Rule.POST:
			try {
				doc = conn.timeout(900000).ignoreContentType(true).post();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		
		// 处理返回数据
		Elements results = new Elements();
		switch (type)  
        {  
        case Rule.CLASS:  
            results = doc.getElementsByClass(resultTagName);  
            break;  
        case Rule.ID:  
            Element result = doc.getElementById(resultTagName);  
            results.add(result);  
            break;  
        case Rule.SELECTION:  
            results = doc.select(resultTagName);  
            break;  
        default:  
            //当resultTagName为空时默认去body标签  
            if ("".equals(resultTagName) || resultTagName == null)  
            {  
                results = doc.getElementsByTag("body");  
            }  
        }  

		for(Element result : results){
			Elements links = result.getElementsByTag("a");
			for(Element link : links){
				String linkHref = link.attr("href");
				String linkText = link.text();
				
				data = new LinkTypeData();
				data.setLinkHref(linkHref);
				data.setLinkText(linkText);
				datas.add(data);
			}
		}
		return datas;
	}
	
	private static void validateRule(Rule rule){
		String url = rule.getUrl();
		if("".equals(url) || url == null){
			throw new RuleException("url 不能为空！");
		}
		
		if(!url.startsWith("http://")){
			throw new RuleException("url的格式不正确！");
		}
		
		if(rule.getParams() != null && rule.getValues() != null){
			if(rule.getParams().length != rule.getValues().length){
				throw new RuleException("参数的键值对个数不匹配！");
			}
		}
	}
}
