package my.设计模式.代理模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  5:30:02 PM
 * explain  : 
 */
public class ProxyClass implements BuyCar{

	private People people;
	
	@Override
	public void buy_myCar() {
		
		if("VIP".equals(people.getVip())){
			people.buy_myCar();
			return;
		}
		if(people.getCash() >= 50000){
			 System.out.println(people.getUserName()+"买了新车，交易结束！");  
		}else{
			 System.out.println(people.getUserName()+"钱不够，不能买车，继续比赛！");
		}
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}
