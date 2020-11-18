package my.数组;
/**
 * @author  : J
 * @version : 2017年6月14日  上午11:11:10
 * explain  : 
 */
public class 多维数组 {
	public static void main(String[] args) {
		
		int d[][] ; // 定义一个二维数组
		d=new int[3][4] ; // 分配3 行4 列数组内存
		
		int a[][]=new int[2][] ;
		a[0]=new int[3] ; // 第二维第一个元素指向3 个整型数
		a[1]=new int[5] ; // 第二维第一个元素指向5 个整型数
		
		// 注意：Java 可以第二维不等长
		int i[][]={{0},{1,4,5},{75,6},{8,50,4,7}} ; //定义和赋初值在一起
		
		
		// 注意：java中二维数组分配空间是第二维可以为空，但是第一维必须分配内存。
		int i1[][]=new int[10][10];
		int []i2[]=new int[10][10];
		int [][]i3=new int[10][10];
		int [][]i4=new int[10][];
//		int i5[][]=new int[10,10]; //错
//		int i6[10][10]=new int[][]; //错
		
		
	}

}
