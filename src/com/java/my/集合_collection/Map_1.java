package my.集合_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  : J
 * @version : Apr 24, 2017  10:45:43 PM
 * explain  : 
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class Map_1 {

	
	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put("userid", 100);
		List clubid = new ArrayList<>();
		clubid.add(200);
		m1.put("clubid", clubid);
		m1.put("diamond", 2);
		
		Map m2 = new HashMap();
		m2.put("userid", 101);
		List clubid2 = new ArrayList<>();
		clubid2.add(200);
		m2.put("clubid", clubid2);
		m2.put("diamond", 2);
		
		Map m3 = new HashMap();
		m3.put("userid", 100);
		List clubid3 = new ArrayList<>();
		clubid3.add(200);
		m3.put("clubid", clubid3);
		m3.put("diamond", 2);

		List<Map> result = new ArrayList<>();
		result.add(m1);
		result.add(m2);
		result.add(m3);

		Map userClub = new HashMap();
		for(int i = 0;i < result.size();i++){
			int userid = Integer.valueOf(result.get(i).get("userid").toString());
			int diamond = (int) result.get(i).get("diamond");
			List<Integer> clubids = (List<Integer>) result.get(i).get("clubid");
			
			for(int j = 0;j < clubids.size();j++){
				String cid = clubids.get(j).toString();
				
				if(userClub.get(userid+"_"+cid)!=null){
					userClub.put(userid+"_"+cid, diamond+Integer.valueOf(userClub.get(userid+"_"+cid).toString()));
				}else {
					userClub.put(userid+"_"+cid, diamond);
				}
				
			}
			
			
		}
		Map clubLog = new HashMap<>();
		for(Object key : userClub.keySet()){
//			System.err.println(key+" "+userClub.get(key));
			String cid = key.toString().split("_")[1];
			if(clubLog.get(cid)!=null){
				clubLog.put(cid, Integer.valueOf(userClub.get(key).toString())+Integer.valueOf(clubLog.get(cid).toString()));
			}else {
				clubLog.put(cid,userClub.get(key));
			}
		}
		System.err.println(clubLog);
	}

}
