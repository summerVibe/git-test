package my.test;
/**
 * @author  : J
 * @version : Jul 26, 2017  2:28:59 PM
 * explain  : 内部类可以引用它的包含类的成员吗？有没有什么限制？
 */
public class 内部内 {
	private static String s = "haha";
	static class inner{
		void say(){
			System.out.println(s);
		}
	}

}
