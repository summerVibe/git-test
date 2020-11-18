package my.设计模式.代理模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  5:26:30 PM
 * explain  : 
 */
public class People implements BuyCar{
	
	private int cash;
	private String vip;
	private String userName;
	
	@Override
	public void buy_myCar() {
		System.out.println(userName+" 是VIP用户，可以直接购买新车！");
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
