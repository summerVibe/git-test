package my.时间日期;
/**
 * @author  : J
 * @version : Jul 21, 2017  3:15:53 PM
 * explain  : 
 */
public class 判断每月天数 {
	
	public static void main(String[] args) {
		getDays(2017, 7);
	}
	
	/** 
	 * 闰年的条件(满足之一即可):(1)能被4整除,但不能被100整除;(2)能被400整除 
	 * @param year 
	 * @param month 
	 * @return 返回天数 
	 */  
	public static int getDays(int year, int month){
		
		int days = 0;
		boolean isLeapYear = false;
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println("----闰年----");
			isLeapYear = true;
		}else{
			System.out.println("----非闰年----");
			isLeapYear = false;
		}
		
		switch(month){
			case 1:  
			case 3:  
			case 5:  
			case 7:  
			case 8:  
			case 10:  
			case 12: 
				days = 31;
				break;
			case 2:
				if (isLeapYear) {  
					days = 29;  
				} else {  
					days = 28;  
				}  
				break;
				
			case 4:  
			case 6:  
			case 9:  
			case 11:  
				days = 30;  
				break;  
			
			default:  
				System.out.println("error!!!");  
				break; 
		}
		
		return days;
	}
}
