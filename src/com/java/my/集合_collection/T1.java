package my.集合_collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;




public class T1 {

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer();
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(5);
		
		String ss = StringUtils.collectionToDelimitedString(list, ",");
		for(int i=0;i<list.size();i++){
			if(list.size() == 1){
				s.append(list.get(i));
			}else if(i >= 1 && i != list.size()-1){
				s.append(list.get(i)).append(",");
			}else if(i == list.size()-1){
				s.append(list.get(i));
			}
		}
		System.out.println(ss.toString());
	}
}
