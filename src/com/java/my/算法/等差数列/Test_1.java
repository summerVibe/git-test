package my.算法.等差数列;

public class Test_1 {
	int a,d,n;
	Test_1(int x,int y,int z){
		a=x;
		d=y;
		n=z;
	}
	public int getSum(){
		int z=0;
		for(int i=0;i<n;i++){
			z=z+a;
			a=a+d;
		}
		return z;
	}
	
	public static void main(String[] args) {
		Test_1 de=new Test_1(1,2,4);
		int z=de.getSum();
		System.out.println(z);
	}
	
	
	

}
