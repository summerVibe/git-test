package my.test;

/**
 * @author  : J
 * @version : Apr 18, 2017 8:31:20 PM 
 * explain  : http://www.cnblogs.com/lanxuezaipiao/p/3371224.html
 *          因为在java里没有引用传递，只有值传递
 *          这个值指的是实参的地址的拷贝，得到这个拷贝地址后，你可以通过它修改这个地址的内容（引用不变），因为此时这个内容的地址和原地址是同一地址，
 *          但是你不能改变这个地址本身使其重新引用其它的对象，也就是值传递，
 */
public class Test_5 {

	String str = new String("good");

	char[] ch = { 'a', 'b', 'c' };

	public static void main(String args[]) {

		Test_5 ex = new Test_5();

		ex.change(ex.str, ex.ch);

		System.out.print(ex.str + " and ");

		System.out.print(ex.ch);

	}

	public void change(String str, char[] ch) {

		str = "test ok";
		ch[0] = 'g';
	}
}
