package my.other;

public class TuZi {

	/**
	 * 6. 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
	 * 假如兔子都不死，问每个月的兔子总数为多少？ (斐波那契数组的实现)基础规律 1 1 2 3 5 8 13
	 * 从第三个数字开始后边的数等于前边两数相加和
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			a = a + b;
			b = a + b;
			System.out.print(a + " - " + b + "\t");
			System.out.println("总和： " + (sum = a + b));
		}

	}

}
