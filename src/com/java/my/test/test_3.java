package my.test;

public class test_3 {

	/**
	 * 存在使i > j || i <= j不成立的数吗？
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = Double.NaN;
		double j = 3;
		int flag = 0;
		if (i > j || i <= j) {
			flag = 1;
		}
		System.out.println(flag);
	}

}
