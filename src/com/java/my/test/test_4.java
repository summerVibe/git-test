package my.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class test_4 {

	/**
	 * @param args
	 */
    public static List<Map<String, String>> jsonToListMap(String json){
    	json = json.trim();
    	//json = json.replaceAll("\r\n(\\S{1,})\r\n","");
    	
    	
    	
    	json = json.replaceAll("[}](\\s*|\t|\r|\n)[{]+","},{");//去空格换行符
    	System.out.println("去空格换行符   ："+json);
    	
    	//json = json.replaceAll("[}]\\s*[{]+","},{");//加逗号
    	//System.out.println("加逗号  ："+json);
    	
    	//json = json.replaceAll("[},]\\s*[{]+",",{");
    	//System.out.println("去空格后   ："+json);
    	
		json = json.replace("},{","}#################{");
		json = json.replace("],[","^");
		json = json.replace("[","");
		json = json.replace("]","");
		json = json.replace("{","");
		json = json.replace("}","");
		String [] jsons= json.split("#################");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String,String> map = null;
		for(String str : jsons){
			map = new HashMap<String,String>();
			list.add(transStringToMap(str));
		}
		
		
    	return list;
	}
	public static Map<String, String> transStringToMap(String mapString){  
		  Map<String, String> map = new HashMap<String, String>();  
		  java.util.StringTokenizer items;  

		  StringTokenizer entrys = new StringTokenizer(mapString, "^");
		  while(entrys.hasMoreTokens()){
			  items = new StringTokenizer(entrys.nextToken(), ",");
			  String key = items.nextToken()+"";
			  String value = "";
			  int i = 0;
			  while(items.hasMoreTokens()){
				  value += (((i++)!=0?",":"")+items.nextToken());
			  }
			  map.put(key, value);
		  }
		  
		  return map;  
	}

    public static void main(String[] args) {
		String j = "{[name,a],[code,111]}\r{[name,b],[code,222]} \n {[name,c],[code,333]}{[name,d],[code,4444]},{[name,e],[code,5555]}";
		jsonToListMap(j);
		//String s="<123>\r\nabc\r\n<456>";
		//System.out.println(s);
	}
}
