package my.this_;
/**
 * @author  : J
 * @version : Aug 25, 2017  4:54:05 PM
 * explain  : http://blog.csdn.net/javaniuniu/article/details/52447502
 */
public class ThisTest1 {
	ThisTest1 tt1 ;
	int i = 1;
	
	public ThisTest1(){
		tt1 = this;
	}
	
	public void test(){
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "ThisTest1 [ i=" + i + "]";
	}

}
