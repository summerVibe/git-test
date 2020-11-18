package my.test;

/**
 * @author : J
 * @version : Apr 18, 2017 7:27:11 PM explain :
 *          http://www.cnblogs.com/lanxuezaipiao/p/3371224.html
 */
// 考查静态语句块、构造语句块（就是只有大括号的那块）以及构造函数的执行顺序。
// 对象的初始化顺序：
// 首先执行父类静态的内容，父类静态的内容执行完毕后，接着去执行子类的静态的内容，当子类的静态内容执行完毕之后，再去看父类有没有非静态代码块，
// 如果有就执行父类的非静态代码块，父类的非静态代码块执行完毕，接着执行父类的构造方法；
// 父类的构造方法执行完毕之后，它接着去看子类有没有非静态代码块，如果有就执行子类的非静态代码块。
// 子类的非静态代码块执行完毕再去执行子类的构造方法。总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
// 而且子类的构造方法，不管这个构造方法带不带参数，默认的它都会先去寻找父类的不带参数的构造方法。如果父类没有不带参数的构造方法，
// 那么子类必须用supper关键子来调用父类带参数的构造方法，否则编译不能通过。
class HelloA {
	public HelloA() {
		System.out.println("HelloA");
	}

	{
		System.out.println("I'm A class");
	}

	static {
		System.out.println("static A");
	}

}

public class 执行顺序 extends HelloA {
	public 执行顺序() {
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm B class");
	}

	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {

		System.out.println("-------main start-------");
		new 执行顺序();
		new 执行顺序();
		System.out.println("-------main end-------");
	}
}
