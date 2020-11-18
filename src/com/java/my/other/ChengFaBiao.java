package my.other;

public class ChengFaBiao {

	/**
	 * 九九乘法表
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1;i <= 9;i++){
			for(int j = 1;i >= j;j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");//     \t——Tab   \n——回车	\r——换行
			}
			System.out.println();
		}
	}
}
