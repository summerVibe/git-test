package my.other;

import java.util.Scanner;
public class HuiWenShu {

	/**一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "[0-9]{5}";
		System.out.println("输入exit退出程序！");
		if(sc.hasNext()){
			for(int i = 0;i< 9999;i++){
				String s = sc.next();
				if(s.matches(regex)){
					int s1 = Integer.parseInt(s);
					int ge = s1 % 10;
					int shi = s1 % 1000/10;
					//int bai = s1 % 100/100;
					int qian = s1 % 1000/10;
					int wan = s1 / 10000;
					if(ge == wan && shi == qian){
						System.out.println("回文数：      "+s1);
					}else{
						System.out.println(s1+"  不是回文数！");
					}
				}if(s.matches("exit")){
					System.out.println("您已退出程序！");
					break;
				}if(!s.matches(regex)){
					System.out.println("你输入的不是五位数字，请重新输入！");
				}
			}
		}
	}

}
