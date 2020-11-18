package my.test;

import java.util.Arrays;

public class test_2 {

	/**
	 * 排序 升序
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {2,7,1,6,9,3};
		int n ;
		for(int j = 0; j < i.length; j++){
			for(int k = 0 ; k < i.length-1; k++ ){
				if(i[k] > i[k+1]){
					n = i[k+1];
					i[k+1] = i[k];
					i[k] = n;
				}
			}
			System.out.println("1      "+Arrays.toString(i));
		}
		System.out.println("2      "+Arrays.toString(i));
		
		double d = 0D;
		double d2 = 0D;
		for(int o = 0; o<i.length-1;o++){
			d2 += i[o]; 
		}
		d = d2 / 2;
		
		
		
	}

}
