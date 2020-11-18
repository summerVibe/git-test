package my.设计模式.工厂模式.简单工厂模式;
/**
 * @author  : J
 * @version : Jul 3, 2017  4:56:35 PM
 * explain  : 
 */
public class Factory {
	
	public BMW createBMW(int type){
		switch(type){
		case 320:
			return new BMW320();
		case 523:
			return new BMW523();
		default:
			break;
		}
		return null;
		
	}

}
