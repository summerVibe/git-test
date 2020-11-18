package my.设计模式.中介者模式;
/**
 * @author  : J
 * @version : Jul 4, 2017  4:13:18 PM
 * explain  : http://www.cnblogs.com/ysw-go/p/5413958.html
 */
public class Colleague {

	protected String name;
	protected Mediator mediator;
	public Colleague(String name, Mediator mediator) {
		 this.name = name;
		 this.mediator = mediator;
	}
}
