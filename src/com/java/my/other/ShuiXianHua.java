package my.other;

public class ShuiXianHua {

	/**
	 * 1.打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
	 * 例如：153是一个“水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 100; i < 1000; i++) {
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 100;
			Math.pow(i, 3);
			if (Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3) == i) {
				System.out.println(i);
			}
		}
	}

}
