package my.other;

/**
 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * @author thinkpad
 *
 */
public class ShuZi4 {
	public static void main(String[] args) {
		int i,j,k = 0;
		for(i = 0;i <= 4;i++){
			for(j = 0;j <= 4;j++){
				for(k = 0;k <= 4;k++){
					if(i != j && j != k && i != k){
						if(i*100+j*10+k > 99){
							System.out.println(i*100+j*10+k);
						}
						
					}
				}
			}
		}
	}
}
