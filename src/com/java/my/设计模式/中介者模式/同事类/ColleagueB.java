package my.设计模式.中介者模式.同事类;
/**
 * @author  : J
 * @version : Jul 4, 2017  3:44:12 PM
 * explain  : 
 */
public class ColleagueB extends AbstractColleague{

	@Override
	public void setNumber(int number, AbstractColleague coll) {
		this.number = number;
		coll.setNumber(number / 100);
	}

}
