package my.算法.二分法;

public class Test_1 {
	
	public static int ef(int a[],int tag){
		// 定义初始最小、最大索引
		int first = 0;
		int end = a.length - 1;
		
		while(first <= end){
			int middle = (first + end) >>> 1;
			if(tag == a[middle] ){
				return middle;
			}
			if(tag > a[middle]){
				first = middle + 1;
			}
			if(tag < a[middle]){
				end = middle - 1;
			}
		}
		return -1;
	}
	
	public static void main(String [] args){
//		int[] i ={6,2,3,4,7,9,1,0}; 
		int[] i ={0,1,1,3,4,5,6,7,11,1100000000}; 
		int tag = 11;
//		System.out.println(ef(i,tag));
		System.out.print(0xff == 255);
	} 
}
