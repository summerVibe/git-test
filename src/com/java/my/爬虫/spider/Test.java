package my.爬虫.spider;

import java.util.List;

/**
 * @author  : J
 * @version : Jul 17, 2017  9:37:36 AM
 * explain  : 
 */
public class Test {
	
	public void printf(List<LinkTypeData> datas){
		for(LinkTypeData data : datas){
			System.out.println(data.getLinkText());  // 链接标题
            System.out.println(data.getLinkHref());  // 链接地址
            System.out.println("***********************************");  
		}
	}
	
//	@org.junit.Test
	public void getDatasByClass(){
		System.out.println("getDatasByClass()---------begin");
		
		Rule rule = new Rule(
				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
				new String[] { "query.enterprisename","query.registationnumber" }, 
				new String[] { "网","" },  
                "cont_right", 
                Rule.CLASS, 
                Rule.POST);
		
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);  
		System.out.println("getDatasByClass()---------end");
	}
	
	@org.junit.Test  
    public void getDatasByCssQuery(){  
    	System.out.println("getDatasByCssQuery()---------begin");
    	
        Rule rule = new Rule(
        		"http://www.11315.com/newsearch",  // 连接地址
                new String[] { "regionMc","regionDm","searchType","searchTypeHead","name" }, 		// 参数集合
                new String[] { "北京市","","","","兴网" },  		// 参数对应值
                "div.g-mn div.con-model", 		// 对返回的html，第一次过滤所用的标签
                Rule.SELECTION, 				// 设置resultTagName的类型
                Rule.GET);  					// 请求类型
        List<LinkTypeData> extracts = ExtractService.extract(rule);  
        printf(extracts);  
        
        System.out.println("getDatasByCssQuery()---------end");
    }  
	
//    @org.junit.Test
	public void getDatasByCssQueryBaidu(){
		Rule rule = new Rule("http://news.baidu.com/ns",  
	            new String[] { "word" }, new String[] { "支付宝" },  
	            null, -1, Rule.GET);  
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    printf(extracts);
	}
	
	
	
}
