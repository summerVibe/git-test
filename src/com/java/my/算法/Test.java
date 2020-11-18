package my.算法;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
	@org.junit.Test
	public void t2(){

		// 有效分类id
		List<String> cateIdList = new ArrayList<>();
		for (int i = 1;i < 10 ; i++) {
			cateIdList.add(i+"");
		}


		// 按项目、分类id统计数据
		List<Map<String,String>> list = new ArrayList<>();
		Map<String,String> map = null;
		for (int i = 2;i<= 8;i++){
			map = new HashMap<>();
			map.put(""+(i-1),""+i);
			map.put(""+i,""+i);
			map.put(""+(i+1),""+i+1);
			map.put("projectId","100");
			list.add(map);
		}
		System.out.println("list   "+JSONArray.toJSONString(list));

		// 按分子公司、分类id统计数据
		List<Map<String,String>> list2 = new ArrayList<>();

		for (String cateId : cateIdList ) {
			map = new HashMap<>();
			map.put(cateId,"0");
			list2.add(map);
		}
		System.out.println("list2  "+JSONArray.toJSONString(list2));


		for (String cateId : cateIdList ) {
			for (Map<String,String> map3 :list2) {
				System.out.println("map3 "+ JSON.toJSONString(map3));
				if (map3.containsKey(cateId)) {
					Integer num = Integer.valueOf(map3.get(cateId));
					for (Map<String,String> map4 :list) {
						if (map4.containsKey(cateId)) {
							num += Integer.valueOf(map4.get(cateId));
						}
					}
					map3.put(cateId,num == 0 ? "0":String.valueOf(num));
				}
			}
		}
		System.out.println("----list2 ---  "+JSONArray.toJSONString(list2));
	}














}
