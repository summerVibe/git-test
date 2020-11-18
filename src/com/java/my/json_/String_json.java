package my.json_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * @author  : J
 * @version : 2017年5月25日  下午4:20:36
 * explain  : 
 */
public class String_json {

	public static void main(String[] args) {
		
		File file = new File("src/com/my/json_/te.txt");
		String temp = null;
		String str = "";
		try {
			FileReader in = new FileReader(file);
			BufferedReader i = new BufferedReader(in);
			while((temp = i.readLine()) != null){
				str = str + temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		List<Map<String, String>> s = jsonToListMap(str);
		for(Map xxx : s){
			System.out.println(xxx.get("Content")+"------------------");
		}
	
//		Map<String, String> m= new HashMap<>();
//		m.put("hh", "ss");
//		System.out.println(m);
//		System.out.println(m.get("hh"));
	}
	public static List<Map<String, String>> jsonToListMap(String st){

		String x = st;
		x = x.replaceAll("Acc: ", "");
		x = x.trim();
		x = x.replace("}{ ", "}####{");
		x = x.replace(": ", "=");
		x = x.replace("}", "");
		x = x.replace("{", "");
		x = x.trim();
		x = x.replace("  ", ",");
		String [] xx= x.split("####");
//		System.out.println(xx[0]+"---");
//		System.out.println(xx[1]+"---");
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String,String> map = null;
		for(String xxx : xx){
			map = new HashMap<String,String>();
			list.add(transStringToMap(xxx.trim()));
		}
    	return list;
	}
	
	public static Map<String, String> transStringToMap(String mapString){  
		  Map<String, String> map = new HashMap<String, String>();  
		  StringTokenizer items;  

		  StringTokenizer entrys = new StringTokenizer(mapString, ",");
		  while(entrys.hasMoreTokens()){
			  items = new StringTokenizer(entrys.nextToken(), "=");
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
}
