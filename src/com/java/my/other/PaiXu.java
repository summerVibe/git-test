package my.other;

import java.util.Scanner;

public class PaiXu {
	/**
	 * 7. 输入五个数并排序输出结果
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[5];
		int temp;
		for (int i = 0; i < 5; i++) {
			System.out.println("请输入第"+(i+1)+"个数字");
			try {
				num[i] = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.out.println("您输入的不是数字，");
			}
		}
		for (int k = 0; k < 5; k++)
			for (int j = 0; j < 4; j++)
				if (num[j] > num[j + 1]) {
					temp = num[j + 1];
					num[j + 1] = num[j];
					num[j] = temp;
				}
		for (int q = 0; q < 5; q++)
			System.out.print(num[q]+" ");
	}
}
